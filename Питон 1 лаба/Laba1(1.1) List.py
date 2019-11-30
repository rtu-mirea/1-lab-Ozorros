from tkinter import *
import List

myList = List.List()

def showList():
    show.set(myList)

def add():
    myList.addToEnd(List.Node(int(entry.get())))

def Delchisl():
    current = myList.head
    while current.next is not None:
        if (current.value<0):
            myList.remove(current)
            break


root = Tk()
root.title("List")
root.geometry("300x300")
show = StringVar()
entry = StringVar()


addButton = Button(root, text="добавить элемент", command= add)
addButton.place(x=0, y=0, width=150, height=50)

addEntry = Entry(root , textvariable = entry)
addEntry.place(x=150, y=0, width=150, height=50)
showButton = Button(root, text="показать список", command=  showList)
showButton.place(x=0, y=50, width=150, height=50)

showButton = Button(root, text="удален. отриц. числа" , command = lambda : Delchisl(myList))
showButton.place(x=150, y=50, width=150, height=50)

showLabel = Label(root, textvariable=show)
showLabel.place(x=0, y=100, width=300, height=200)

root.mainloop()
