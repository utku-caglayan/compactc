package schema

import (
	"encoding/json"
	"strings"
	"testing"

	"github.com/stretchr/testify/assert"
	"github.com/stretchr/testify/require"
)

func TestValidateJSONSchemaString(t *testing.T) {
	tcs := []struct {
		name        string
		schema      string
		isErr       bool
		noSchemaErr bool
		errString   string
	}{
		{
			name:   "non-json string",
			schema: "",
			isErr:  true,
		},
		{
			name:        "valid",
			schema:      Valid,
			errString:   "",
			noSchemaErr: true,
		},
		{
			name:        "valid custom field type defined in schema",
			schema:      ValidNewFieldTypeDefined,
			errString:   "",
			noSchemaErr: true,
		},
		{
			name:      "mandatory class field is missing",
			schema:    "{}",
			errString: "classes is required",
		},
		{
			name: "mandatory 'fields' field of class is missing",
			schema: `{ "classes":[
                     {
                        "name":"Employee"
                     }
                  ]
           }`,
			errString: "fields is required",
		},
		{
			name: "mandatory 'name' field in 'fields' field is missing",
			schema: `{ "classes":[
                     {
                        "name":"Employee",
                        "fields":[
                           {
                              "type":"Work"
                           }
                        ]
                     }
                  ]
           }`,
			errString: "name is required",
		},
		{
			name: "mandatory 'type' field in 'fields' field is missing",
			schema: `{ "classes":[
                     {
                        "name":"Employee",
                        "fields":[
                           {
                              "name":"age"
                           }
                        ]
                     }
                  ]
           }`,
			errString: "type is required",
		},
	}
	for _, tc := range tcs {
		t.Run(tc.name, func(t *testing.T) {
			valid, errors, err := validateJSONSchemaString(tc.schema)
			assert.Equal(t, tc.isErr, err != nil)
			if tc.isErr {
				return
			}
			assert.Nil(t, err)
			if tc.noSchemaErr {
				assert.Empty(t, errors)
				assert.True(t, valid)
				return
			}
			assert.False(t, valid)
			assert.Contains(t, strings.Join(errors, ","), tc.errString)
		})
	}
}

func TestValidateSchemaSemantics(t *testing.T) {
	tcs := []struct {
		name   string
		schema string
		isErr  bool
		err    string
	}{
		{
			name:   "invalid field type",
			schema: InvalidFieldType,
			isErr:  true,
			err:    "not one of the builtin types or not defined",
		},
		{
			name: "valid field type defined in schema",
			schema: `{
                  "classes":[
                     {
                        "name":"Employee",
                        "fields":[
                           {
                              "name":"age",
                              "type":"Work"
                           }
                        ]
                     },
                     {
                        "name":"Work",
                        "fields":[]
                     }
                  ]
           }`,
		},
		{
			name: "duplicate compact class",
			schema: `{
                  "classes":[
                     {
                        "name":"Employee",
                        "fields":[
                           {
                              "name":"age",
                              "type":"Work"
                           }
                        ]
                     },
                     {
                        "name":"Employee",
                        "fields":[]
                     }
                  ]
           }`,
			isErr: true,
			err:   "already exist",
		},
		{
			name: "valid array field type",
			schema: `{
                  "classes":[
                     {
                        "name":"Employee",
                        "fields":[
                           {
                              "name":"age",
                              "type":"nullableInt16[]"
                           }
                        ]
                     }
                  ]
           }`,
		},
		{
			name: "invalid array field type",
			schema: `{
                  "classes":[
                     {
                        "name":"Employee",
                        "fields":[
                           {
                              "name":"age",
                              "type":"[]"
                           }
                        ]
                     }
                  ]
           }`,
			isErr: true,
			err:   "not one of the builtin types or not defined",
		},
	}
	for _, tc := range tcs {
		t.Run(tc.name, func(t *testing.T) {
			var schema map[string]interface{}
			require.Nil(t, json.Unmarshal([]byte(tc.schema), &schema))
			_, err := ValidateSemantics(schema)
			if !tc.isErr {
				assert.Nil(t, err)
				return
			}
			assert.Contains(t, err.Error(), tc.err)
		})
	}
}

const (
	Valid = `{ "classes":[
                  {
                     "name":"Employee",
                     "fields":[
                        {
                           "name":"age",
                           "type":"int32[]"
                        },
                        {
                           "name":"name",
                           "type":"string"
                        },
                        {
                           "name":"id",
                           "type":"int64",
                           "default":1231231
                        }
                     ]
                  }
               ]
        }`
	InvalidFieldType = `{
               "classes":[
                  {
                     "name":"Employee",
                     "fields":[
                        {
                           "name":"age",
                           "type":"Work"
                        }
                     ]
                  }
               ]
        }`
	ValidNewFieldTypeDefined = `{
                  "classes":[
                     {
                        "name":"Employee",
                        "fields":[
                           {
                              "name":"age",
                              "type":"Work"
                           }
                        ]
                     },
                     {
                        "name":"Work",
                        "fields":[]
                     }
                  ]
           }`
)
