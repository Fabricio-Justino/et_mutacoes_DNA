
OUT = ./dist
SRC = ./src

all: dots graph

dots:
	@javac -d $(OUT) $(SRC)/*.java

graph: dots
	@java -cp $(OUT) GraphDots
	@python ./src/GraphPlot.py