import machine
import ssd1306
import time
import socket

SCREEN_PINS = [12, 13]
display = None

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

def connect():
    s.connect(('ip-here', 6060))


def start():
    global display

    i2c = machine.I2C(scl=machine.Pin(SCREEN_PINS[1]), sda=machine.Pin(SCREEN_PINS[0]))
    display = ssd1306.SSD1306_I2C(128, 64, i2c)

    while True:
	message = s.recv(1024).decode('utf-8')
	print(message)	

	if str(message).startswith("[MINED:"):
	    display.fill(0)
	    display.text(message, 0, 0)
	    display.show()
