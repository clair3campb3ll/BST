# binary search program makefile
# Claire Campbell

CLASSES = BinaryTreeNode  BTQueueNode BTQueue BinaryTree \
	BinarySearchTree BinarySearchTreeTest \
	Posts Account Toktik

.SUFFIXES: .java .class 

bin/%.class:src/%.java 
	javac -d bin -cp bin $<

classes: $(CLASSES:%=bin/%.class)

clean:
	rm bin/*.class