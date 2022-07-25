package schema

import (
	"bytes"
	"encoding/json"
	"fmt"
	"strings"

	"github.com/xeipuuv/gojsonschema"
	"gopkg.in/yaml.v2"

	"compactc/common"
)

func ValidateWithJSONSchema(schema map[string]interface{}) (isValid bool, schemaErrors []string, err error) {
	jsonSchemaString, err := json.Marshal(schema)
	if err != nil {
		return false, nil, err
	}
	return validateJSONSchemaString(string(jsonSchemaString))
}

func YAMLToMap(yamlSchema []byte) (map[string]interface{}, error) {
	s := make(map[interface{}]interface{})
	if err := yaml.Unmarshal(yamlSchema, &s); err != nil {
		return nil, err
	}
	// convert map[interface{}]interface{} to map[string]interface{}
	i := ConvertMapI2MapS(s)
	schema, ok := i.(map[string]interface{})
	if !ok {
		return nil, fmt.Errorf("malformed schema")
	}
	return schema, nil
}

func ValidateSemantics(mapSchema map[string]interface{}) (schema common.Schema, err error) {
	if err = transcode(mapSchema, &schema); err != nil {
		return
	}
	// detect duplicate classes
	classNames := make(map[string]common.Class)
	for _, c := range schema.Classes {
		if _, ok := classNames[c.Name]; ok {
			return common.Schema{}, fmt.Errorf("compact class with name %s already exist", c.Name)
		}
		classNames[c.Name] = c
	}
	// check all field types are valid
	for _, c := range schema.Classes {
		for _, f := range c.Fields {
			t := f.Type
			if strings.HasSuffix(t, "[]") {
				// if type is an array type, loose the brackets and validate underlying type
				t = t[:len(t)-2]
			}
			if isBuiltInType(t) {
				continue
			}
			if isCompactName(t, classNames) {
				continue
			}
			return common.Schema{}, fmt.Errorf("validation error: field type '%s' is not one of the builtin types or not defined", t)
		}
	}
	return
}

func transcode(in, out interface{}) error {
	buf := new(bytes.Buffer)
	if err := json.NewEncoder(buf).Encode(in); err != nil {
		return err
	}
	return json.NewDecoder(buf).Decode(out)
}

func validateJSONSchemaString(schema string) (isValid bool, schemaErrors []string, err error) {
	schemaLoader := gojsonschema.NewStringLoader(schema)
	vsl := gojsonschema.NewStringLoader(validationSchema)
	result, err := gojsonschema.Validate(vsl, schemaLoader)
	if err != nil {
		return false, nil, err
	}
	if isValid = result.Valid(); !isValid {
		for _, e := range result.Errors() {
			schemaErrors = append(schemaErrors, e.String())
		}
	}
	return isValid, schemaErrors, nil
}

func isBuiltInType(t string) bool {
	t = strings.ToLower(t)
	for _, bt := range builtinTypes {
		if t == strings.ToLower(bt) {
			return true
		}
	}
	return false
}

func isCompactName(t string, compactNames map[string]common.Class) bool {
	for cn := range compactNames {
		if t == cn {
			return true
		}
	}
	return false
}

var builtinTypes = []string{
	"boolean",
	"int8",
	"int16",
	"int32",
	"int64",
	"float32",
	"float64",
	"string",
	"decimal",
	"time",
	"date",
	"timestamp",
	"timestampWithTimezone",
	"nullableBoolean",
	"nullableInt8",
	"nullableInt16",
	"nullableInt32",
	"nullableInt64",
	"nullableFloat32",
	"nullableFloat64",
}

const validationSchema = `{
  "$schema": "http://json-schema.org/draft-07/schema#",
  "id": "https://github.com/hazelcast/hazelcast-client-protocol/blob/master/schema/protocol-schema.json",
  "title": "Hazelcast Client Protocol Definition",
  "type": "object",
  "definitions": {},
  "additionalProperties": false,
  "properties": {
    "classes": {
      "type": "array",
      "items": {
        "type": "object",
        "additionalProperties": false,
        "properties": {
          "name": {
            "type": "string"
          },
          "fields": {
            "type": "array",
            "items": {
              "type": "object",
              "additionalProperties": false,
              "properties": {
                "name": {
                  "type": "string"
                },
                "type": {
                  "type": [
                    "string"
                  ]
                },
                "default": {
                  "type": [
                    "number",
                    "boolean"
                  ]
                }
              },
              "required": [
                "name",
                "type"
              ]
            },
            "minItems": 0,
            "uniqueItems": false
          }
        },
        "required": [
          "name",
          "fields"
        ]
      }
    }
  },
  "required": [
    "classes"
  ]
}`
