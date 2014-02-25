# -*- coding:utf8 -*-
import Tkinter

#HA LE AKAROD CSERÉLNI A PÁLYA MÉRETÉT, KÉRLEK ITT TEDD!
MAGASSAG  = 25 # sorok száma
SZELESSEG = 25 # oszlopok száma

#CONSTANTS
EPITESI,UT,KEZDET,VEG = 0,1,2,3 # Guba Said So.
DEBUGBULLSHIT = ["építési","út","kezdet","vég"]
COLORZ = ["green", "brown", "red", "blue"] #Csak valami random reprezentáció.
FELBONTAS = 15 # egy négyzet hányszor hány pixel legyen megjelenítéskor. 
global watDidIChangeLastX
global watDidIChangeLastY
watDidIChangeLastX = 0
watDidIChangeLastY = 0
#FUNCTIONS
def ketDimKiiras(ketDimTomb):
	for y in ketDimTomb:
		for x in y:
			print x,
		print "" #all i need is a new line from youuuu


def kiirV1(fileName, ketDimTomb):
	f = open(fileName, 'w')
	for y in ketDimTomb:
		for x in y:
			f.write(str(x))
			f.write(" ")
		f.write(";\n")
	debugLine.set("File succesfully saved to : "+fileName)
	
def butaKiir():
	kiirV1(hovaMentsen.get(), mezok)

def onCanvasLeftClick(event): 	
	hanyadikSor = int(event.y/FELBONTAS)
	hanyadikOszlop = int(event.x/FELBONTAS)
	aktualisElem = mezok[hanyadikSor][hanyadikOszlop]
	volt = aktualisElem
	if aktualisElem == EPITESI:
		mezok[hanyadikSor][hanyadikOszlop] = UT
		aktualisElem = UT
	else:
		mezok[hanyadikSor][hanyadikOszlop] = EPITESI
		aktualisElem = EPITESI
	lett = mezok[hanyadikSor][hanyadikOszlop]
	debugLine.set(str("volt: ")+str(DEBUGBULLSHIT[volt])+str("\tlett:  ")+str(DEBUGBULLSHIT[lett])+"\tx="+str(hanyadikOszlop)+"\ty="+str(hanyadikSor) )
	kirajzoloSzin = COLORZ[aktualisElem]
	watDidIChangeLastX = hanyadikSor
	watDidIChangeLastY = hanyadikOszlop
	vaszon.create_rectangle(hanyadikOszlop*FELBONTAS+1, hanyadikSor*FELBONTAS+1, (hanyadikOszlop+1) * FELBONTAS+1, (hanyadikSor+1) * FELBONTAS+1, fill = kirajzoloSzin)

def onDraggedWhileMouseButtonIsPressed(event):
	global watDidIChangeLastX
	global watDidIChangeLastY
	global radioGombAltalKivalasztott
	if(   ((0 < event.x) and (0 < event.y) and (event.x < GRAFSZEL) and (event.y < GRAFMAG)) ): 
		hanyadikSor    = int(event.y/FELBONTAS)
		hanyadikOszlop = int(event.x/FELBONTAS)
		if(not ( (watDidIChangeLastX == hanyadikOszlop) and (watDidIChangeLastY == hanyadikSor) )):
			watDidIChangeLastX = hanyadikOszlop
			watDidIChangeLastY = hanyadikSor
			aktualis = radioGombAltalKivalasztott.get()
			mezok[hanyadikSor][hanyadikOszlop] = radioGombAltalKivalasztott.get()
			kirajzoloSzin = COLORZ[aktualis]
			vaszon.create_rectangle(hanyadikOszlop*FELBONTAS+1, hanyadikSor*FELBONTAS+1, (hanyadikOszlop+1) * FELBONTAS+1, (hanyadikSor+1) * FELBONTAS+1, fill = kirajzoloSzin)


#copy-paste is on my side with this one.
def onCanvasRightClick(event): 	
	hanyadikSor = int(event.y/FELBONTAS)
	hanyadikOszlop = int(event.x/FELBONTAS)
	aktualisElem = mezok[hanyadikSor][hanyadikOszlop]
	volt = aktualisElem
	if aktualisElem == VEG:
		mezok[hanyadikSor][hanyadikOszlop] = KEZDET
		aktualisElem = KEZDET
	else:
		mezok[hanyadikSor][hanyadikOszlop] = VEG
		aktualisElem = VEG
	lett = mezok[hanyadikSor][hanyadikOszlop]
	debugLine.set(str("volt: ")+str(DEBUGBULLSHIT[volt])+str("\tlett:  ")+str(DEBUGBULLSHIT[lett])+"\tx="+str(hanyadikOszlop)+"\ty="+str(hanyadikSor) )
	kirajzoloSzin = COLORZ[aktualisElem]
	vaszon.create_rectangle(hanyadikOszlop*FELBONTAS+1, hanyadikSor*FELBONTAS+1, (hanyadikOszlop+1) * FELBONTAS+1, (hanyadikSor+1) * FELBONTAS+1, fill = kirajzoloSzin)





def mindentKirajzol(ketDimTomb, vaszony, felbontas , szinek):
	varY = 0
	for y in ketDimTomb:
		varX = 0
		for x in y:
			jelenSzin = szinek[x]
			vaszony.create_rectangle(varX*felbontas+1, varY*felbontas+1, (varX+1)*felbontas+1 , (varY+1)*felbontas +1, fill=jelenSzin)		
			varX += 1
		varY += 1
	


#mainloop

#MAGASSAG  =  int(raw_input( "Adjad meg a tomb magassagat\t" ))
#SZELESSEG =  int(raw_input( "Adjad meg a tomb szelesseget\t" ))
global mezok
mezok    =  [] 
for y in range(MAGASSAG):
	mezok.append([])
	for x in range(SZELESSEG):
		mezok[y].append(EPITESI)
	
#grafikai mainloop
GRAFSZEL = SZELESSEG * FELBONTAS
GRAFMAG = MAGASSAG * FELBONTAS
ablakom = Tkinter.Tk () 
vaszon = Tkinter.Canvas(ablakom, width = GRAFSZEL+1 , height = GRAFMAG+1)
global debugLine
debugLine = Tkinter.StringVar()
debugger  = Tkinter.Label(ablakom,textvariable = debugLine)
kilepes = Tkinter.Button(ablakom, text = "EXIT", command = ablakom.destroy)
mentes = Tkinter.Button(ablakom, text = "SAVE", command = butaKiir)
global HovaMentsen
hovaMentsen = Tkinter.Entry(ablakom)
hovaMentsen.insert(0,"nothingSpecified.map")
debugLine.set("This Is Just Debug")
global radioGombAltalKivalasztott
radioGombAltalKivalasztott = Tkinter.IntVar()


#GRIDS
vaszon.grid(column = 0, row = 0, columnspan = 500, padx = 5, pady = 5 ) # senkivle sem lesz egy sorban
debugger.grid(column = 0, row = 1, columnspan = 500)
kilepes.grid(column = 0, row = 3)
mentes.grid(column = 0, row = 2)
hovaMentsen.grid(column = 1, row = 2)
Tkinter.Radiobutton(ablakom, text = DEBUGBULLSHIT[0], variable = radioGombAltalKivalasztott, value = 0).grid(column = 2, row = 2)
Tkinter.Radiobutton(ablakom, text = DEBUGBULLSHIT[1], variable = radioGombAltalKivalasztott, value = 1).grid(column = 2, row = 3)
#/GRIDS

#BINDING
vaszon.bind("<Button-1>", onCanvasLeftClick)
vaszon.bind("<Button-3>", onCanvasRightClick)
vaszon.bind("<B1-Motion>", onDraggedWhileMouseButtonIsPressed) 
#/BINDING


mindentKirajzol(mezok, vaszon, FELBONTAS , COLORZ)

#atadom az iranyitast
ablakom.mainloop()

ketDimKiiras(mezok)
kiirV1("failsafe.map", mezok)
