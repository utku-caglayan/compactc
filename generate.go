package compactc

import (
	"fmt"
	"strings"

	"compactc/common"
	"compactc/java"
	pschema "compactc/schema"
)

type Lang string

const (
	JAVA       = "java"
	PYTHON     = "py"
	TYPESCRIPT = "ts"
	CPP        = "cpp"
	GO         = "go"
	CSHARP     = "cs"
)

var SupportedLangs = []string{JAVA, PYTHON, TYPESCRIPT, CPP, GO, CSHARP}

func IsLangSupported(lang string) bool {
	lang = strings.ToLower(lang)
	for _, sl := range SupportedLangs {
		if lang == sl {
			return true
		}
	}
	return false
}

func GenerateCompactClasses(lang string, schema string, namespace string) (map[common.ClassAndFileName]string, error) {
	schemaMap, err := pschema.YAMLToMap([]byte(schema))
	if err != nil {
		return nil, err
	}
	isValid, schemaErrors, err := pschema.ValidateWithJSONSchema(schemaMap)
	if err != nil {
		return nil, err
	}
	if !isValid {
		return nil, fmt.Errorf("Schema is not valid, validation errors:\n%s\n", strings.Join(schemaErrors, "\n"))
	}
	sch, err := pschema.ValidateSemantics(schemaMap)
	if err != nil {
		return nil, err
	}
	// compactSchema name to generated compactSchema
	classes := make(map[common.ClassAndFileName]string)
	switch lang {
	case JAVA:
		javaClasses := java.Generate(sch, namespace)
		for jc := range javaClasses {
			classes[common.ClassAndFileName{
				FileName:  fmt.Sprintf("%s.java", jc),
				ClassName: jc,
			}] = javaClasses[jc]
		}
	case PYTHON:
		panic(any("implement me"))
	case TYPESCRIPT:
		panic(any("implement me"))
	case CPP:
		panic(any("implement me"))
	case GO:
		panic(any("implement me"))
	case CSHARP:
		panic(any("implement me"))
	default:
		return nil, fmt.Errorf("unsupported langugage")
	}
	return classes, nil
}
