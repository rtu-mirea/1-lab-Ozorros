class Node:

    def __init__(self, value):
        self.value = value
        self.next = None


class List:

    def __init__(self, node=None):
        self.head = node

    def clear(self):
        self.head = None

    def addToEnd(self, node):
        if self.head is None:
            self.head = node
        else:
            current = self.head
            while (current.next is not None):
                current = current.next
            current.next = node

    def addToBegin(self, node):
        if self.head is None:
            self.head = node
        else:
            node.next = self.head
            self.head = node

    def remove(self, position: int):
        current = self.head
        for i in range(position):
            current = current.next
        current.next = current.next.next

    def __str__(self):
        if self.head != None:
            current = self.head
            out =  str(current.value)+' '
            while current.next != None:
                current = current.next
                out += str(current.value) + " "
            return out
        return 'Список пуст'



