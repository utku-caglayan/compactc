package main

import (
	"flag"
	"fmt"
	"io/fs"
	"io/ioutil"
	"os"
	"path"
	"strings"

	"compactc"
)

// flags
var (
	namespace string
	silent    bool
	outDir    string
)

func init() {
	flag.StringVar(&namespace, "namespace", "test", "example: com.hazelcast")
	flag.BoolVar(&silent, "silent", false, "")
	flag.StringVar(&outDir, "output-dir", "./generated", "")
	flag.Usage = func() {
		exp := `Hazelcast Code Generator for Compact Serializer.

positional arguments:
  LANGUAGE              Language to generate codecs for. Possible values are [java cpp cs py ts go]
  SCHEMA_FILE_PATH      Root directory for schema files`
		// nothing to do on err, hence skip
		_, _ = fmt.Fprintf(os.Stderr, "Usage: %s [-h] [--namespace NAMESPACE] [--silent] [--output-dir OUTPUT_DIRECTORY] LANGUAGE SCHEMA_FILE_PATH\n%s", os.Args[0], exp)
		flag.PrintDefaults()
	}
}

var (
	// selected language to generate source for
	lang string
	// path to code generation schema
	schemaPath string
)

func main() {
	flag.Parse()
	if flag.NArg() != 2 {
		exitWithErr("Error: LANGUAGE and SCHEMA_FILE_PATH must be provided\n")
		flag.Usage()
	}
	lang = flag.Arg(0)
	schemaPath = flag.Arg(1)
	if !compactc.IsLangSupported(lang) {
		exitWithErr("Error: Unsupported language, you can provide one of %s", strings.Join(compactc.SupportedLangs, ","))
	}
	// todo check if outdir and schema dir exists and accessible
	// validate schemaErr
	yamlSchema, err := ioutil.ReadFile(schemaPath)
	if err != nil {
		exitWithErr("Error: Can not read schema %s", err.Error())
	}
	classes, err := compactc.GenerateCompactClasses(lang, string(yamlSchema), namespace)
	if err = os.MkdirAll(outDir, fs.ModePerm); err != nil {
		exitWithErr("Error: Can not write generated source, path %s, err: %s", outDir, err.Error())
	}
	var accumulateErr strings.Builder
	for k, v := range classes {
		if err = os.WriteFile(path.Join(outDir, k.FileName), []byte(v), fs.ModePerm); err != nil {
			accumulateErr.WriteString(err.Error() + "\n")
		}
	}
	if err != nil {
		exitWithErr("Error: Things went wrong while writing genereated source:\n%s", err.Error())
	}
	return
}

func exitWithErr(format string, a ...any) {
	// nothing to do if err, so skip
	_, _ = fmt.Fprintf(os.Stderr, format, a...)
	flag.Usage()
	os.Exit(1)
}
