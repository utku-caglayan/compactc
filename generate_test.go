package compactc_test

import (
	"io/ioutil"
	"path"
	"runtime"
	"testing"

	"github.com/stretchr/testify/require"

	"compactc"
	"compactc/common"
)

var (
	allTypesJava,
	typesWithDefaultsJava,
	exampleSchema string
)

func init() {
	_, filename, _, _ := runtime.Caller(0)
	testdata := path.Join(path.Dir(filename), "testdata")
	allTypesJava = readTestFile(testdata, "AllTypes.java")
	typesWithDefaultsJava = readTestFile(testdata, "TypesWithDefaults.java")
	exampleSchema = readTestFile(path.Join(path.Dir(filename), "testdata"), "exampleSchema.yaml")
}

func readTestFile(dir string, fName string) string {
	f, err := ioutil.ReadFile(path.Join(dir, fName))
	if err != nil {
		panic(err)
	}
	return string(f)
}

func makeKey(className, fileName string) common.ClassAndFileName {
	return common.ClassAndFileName{
		FileName:  fileName,
		ClassName: className,
	}
}

func TestGenerate(t *testing.T) {
	tcs := []struct {
		expected      map[common.ClassAndFileName]string
		name          string
		lang          string
		compactSchema string
	}{
		{
			name: "TypesWithDefaultsJava",
			lang: "java",
			expected: map[common.ClassAndFileName]string{
				makeKey("TypesWithDefaults", "TypesWithDefaults.java"): typesWithDefaultsJava,
				makeKey("AllTypes", "AllTypes.java"):                   allTypesJava,
			},
			compactSchema: exampleSchema,
		},
	}
	for _, tc := range tcs {
		t.Run(tc.name, func(t *testing.T) {
			classes, err := compactc.GenerateCompactClasses(tc.lang, tc.compactSchema, "test")
			if err != nil {
				t.Fail()
			}
			require.Equal(t, tc.expected, classes)
		})
	}
}
