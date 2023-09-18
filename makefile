
OUT = ./dist
SRC = ./src

MAX_X = 10000
DNA = DNADNAANDNDA

FILE_PATH = none
GRAPH_TIME = OFF

all: dots graph

dots:
	@javac -d $(OUT) $(SRC)/*.java

graph: dots
	@java -cp $(OUT) GraphDots $(MAX_X) $(GRAPH_TIME)
	@python ./src/GraphPlot.py

run: dots
	@java -cp $(OUT) Main $(DNA)

run_file: dots
	@java -cp $(OUT) FileReader $(FILE_PATH)

.PHONY: clean

clean:
	rm ./dist/*