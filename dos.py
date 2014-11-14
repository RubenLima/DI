import sys
import pygtk
import sqlite3
import gtk
import gtk.glade
import gtk.gdk
bd = "tablausuario"
conex = sqlite3.connect(bd)
a = conex.cursor()
from gi.repository import Gtk
def userEntryChanged(self):
	print "on_entry1_changed"
def pwdEntryChanged(self):
	print "on_entry2_changed"
def emailEntryChanged():
	print "on_entry3_changed"
def nameEntryChanged():
	print "on_entry4_changed"
def surnameEntryChanged():
	print "on_entry5_changed"
def dirEntryChanged():
	print "on_entry6_changed"

	class MainWin:

	def __init__(self):
		self.widgets  = gtk.glade.XML("practica2.glade")	
		window1 = glade.get_object("window1")

		signals = {"on_button1_clicked" : self.on_button1_clicked,
			"on_button2_clicked": self.on_button2_clicked,
			"on_button3_clicked": self.on_button3_clicked,
			"gtk_main_quit" : gtk.main_quit
			 }





def cleanBtnClicked(self):
	print "cleanBtnClicked"
# Entry Cleaner Function
	glade.get_object("entry1").set_text("")
	glade.get_object("entry2").set_text("")
	glade.get_object("entry3").set_text("")
	glade.get_object("entry4").set_text("")
	glade.get_object("entry5").set_text("")
	glade.get_object("entry6").set_text("")



def listarBtnClicked(self, widget,bbdd):
	#print "listarBtnClicked" 
	ventana = gtk.Dialog()
		ok_button = ventana.add_button(gtk.STOCK_OK, gtk.RESPONSE_OK)
		cancelar_button = ventana.add_button(gtk.STOCK_CANCEL, gtk.RESPONSE_CANCEL)
		ok_button.grab_default()
		ventana.set_title("Listar")

		c.execute('SELECT * FROM tablausuario;')

		for x in c.fetchall():
			entry1 = gtk.Label("Usuario: "+x[0])
			ventana.vbox.pack_start(entry1, True, True, 0)

		ventana.show_all()
		ventana.run()
		ventana.destroy()
		
		




		#entry1 = gtk.Label("Usuario: "+self.widgets.get_widget("entry1").get_text())
		#entry2 = gtk.Label("pass: "+self.widgets.get_widget("entry2").get_text())
		#entry3 = gtk.Label("E-mail: "+self.widgets.get_widget("entry3").get_text())
		#entry4 = gtk.Label("Nombres: "+self.widgets.get_widget("entry4").get_text())
		#entry5 = gtk.Label("Apellidos: "+self.widgets.get_widget("entry5").get_text())
		#entry6 = gtk.Label("direccion: "+self.widgets.get_widget("entry6").get_text())




	
	
	#lista usuarios revisar nombre 
	self.entry1.set_text("Hola %s"%texto)
def grabarBtnClicked(self, widget,bbdd):
	
	usuario=self.widgets.get_widget("entry1").get_text()
	pass=self.widgets.get_widget("entry2").get_text()
	email=self.widgets.get_widget("entry3").get_text()
	nombre=self.widgets.get_widget("entry4").get_text()
	apellidos=self.widgets.get_widget("entry5").get_text()
	direccion=self.widgets.get_widget("entry6").get_text()
	a.execute('insert into tablausuario(usuario,pass,email,nombre,apellidos,direccion) values ("'+str(usuario)+'","'+str(pass)+'","'+str(email)+'","'+str(nombre)+'","'+str(apellidos)+'","'+str(direccion)+'")')
		conex.commit()

def on_button1_clicked(self, widget):
	texto=self.entry1.get_text()
	
	


	
def gtk_main_quit():
	Gtk.main_quit()
######################### MAIN #########################
if __name__ == "__main__":
	glade = Gtk.Builder()
	#glade.add_from_file
	#self.widgets  = gtk.glade.XML("practica2.glade")
	signals = { "on_entry1_changed": userEntryChanged,"on_entry2_changed": pwdEntryChanged,"on_entry3_changed": emailEntryChanged,"on_entry4_changed": nameEntryChanged,"on_entry5_changed": surnameEntryChanged,"on_entry6_changed": dirEntryChanged,"on_button3_clicked": cleanBtnClicked,"on_button2_clicked": grabarBtnClicked,"on_button1_clicked": listarBtnClicked,"gtk_main_quit": Gtk.main_quit }
	#glade.connect_signals(signals)
	self.widgets.signal_autoconnect(signals)	
	#window1 = glade.get_object("window1")
	window.show_all()
	Gtk.main()