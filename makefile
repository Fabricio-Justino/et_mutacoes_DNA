
OUT = ./dist
SRC = ./src

MAX_X = 10000

all: dots graph

dots:
	@javac -d $(OUT) $(SRC)/*.java

graph: dots
	@java -cp $(OUT) GraphDots $(MAX_X)
	@python ./src/GraphPlot.py


.PHONY: clean

clean:
	rm ./dist/*