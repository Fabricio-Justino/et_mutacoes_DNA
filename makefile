
OUT = ./dist
SRC = ./src

MAX_X = 10000
DNA = DNADNAANDNDA

all: dots graph

dots:
	@javac -d $(OUT) $(SRC)/*.java

graph: dots
	@java -cp $(OUT) GraphDots $(MAX_X)
	@python ./src/GraphPlot.py

run: dots
	@java -cp $(OUT) Main $(DNA)

.PHONY: clean

clean:
	rm ./dist/*