.PHONY: build test test-cover view-cover

TEST_FLAGS ?= -v -count 1
COVERAGE_OUT = coverage.out

build:
	go build -o compactc ./cmd

test:
	go test $(TEST_FLAGS) ./...

test-cover:
	go test $(TEST_FLAGS) -coverprofile=$(COVERAGE_OUT) ./...

view-cover:
	go tool cover -func $(COVERAGE_OUT) | grep total:
	go tool cover -html $(COVERAGE_OUT) -o coverage.html
