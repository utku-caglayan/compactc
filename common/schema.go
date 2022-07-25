package common

import "encoding/json"

type Schema struct {
	Classes []Class `yaml,json:"classes"`
}

type Class struct {
	Name   string  `yaml,json:"name"`
	Fields []Field `yaml,json:"fields"`
}

type Field struct {
	Name    string          `yaml,json:"name"`
	Type    string          `yaml,json:"type"`
	Default json.RawMessage `yaml,json:"default"` // note this is optional
}

type ClassAndFileName struct {
	FileName  string
	ClassName string
}
