# binary search program makefile
# Claire Campbell

JAVAC=usr/bin/javac
JAVA=/usr/bin/java

.SUFFIXES: .java .class 
SRCDIR=src
BINDIR=bin

$(BINDIR)/%.class:$(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) $<

CLASSES = src/BinaryTreeNode.java \
	src/BTQueueNode.java src/BTQueue.java src/BinaryTree.java \
	src/BinarySearchTree.java src/Post.java src/Account.java src/Toktik.java 

CLASS_FILES=$(CLASSES:%.class=$(BINDIR)/%.class)

default: $(CLASS_FILES)

clean:
	rm $(BINDIR)/*.class

run: $(CLASS_FILES)
	$(JAVA) -cp bin Toktik