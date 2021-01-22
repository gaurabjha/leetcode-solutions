import datetime

import pyjokes
import pyttsx3
import pywhatkit
import speech_recognition as sr
import wikipedia

listener = sr.Recognizer()
listener.dynamic_energy_threshold = True

engine = pyttsx3.init()
voices = engine.getProperty('voices')
for voice in voices:
    print("Voice:")
    print(" - ID: %s" % voice.id)
    print(" - Name: %s" % voice.name)
    print(" - Languages: %s" % voice.languages)
    print(" - Gender: %s" % voice.gender)
    print(" - Age: %s" % voice.age)
ENG_IN_VEENA = 'com.apple.speech.synthesis.voice.veena'
HINDI_IN_LEKHA = 'com.apple.speech.synthesis.voice.lekha'
engine.setProperty('voice', HINDI_IN_LEKHA)
#engine.setProperty('voice', ENG_IN_VEENA)
engine.say("Initializing the Program, please wait!")
engine.runAndWait()

def talk(text):
    engine.say(text)
    engine.runAndWait()

global command

def take_command():
    try:
        with sr.Microphone() as source:
            print('listening...')
            voice = listener.listen(source, phrase_time_limit=5)
            print("Recognizing...")

            command = listener.recognize_google(voice)
            command = command.lower()

        if 'prity' in command:
                command = command.replace('prity', '')
                print(f"User said: {command}\n")
        else:
            talk("हेलो मेरा नाम प्रिटी है , मुझे प्रिटी ही बुलाये ")
    except Exception as e:
        print(e)
        print("Please Say that again!")
        return "None"
    return command


def run_alexa():
    command = take_command()
    print(command)
    if 'play' in command:
        song = command.replace('play', '')
        talk('playing ' + song)
        pywhatkit.playonyt(song)
    elif 'time' in command:
        time = datetime.datetime.now().strftime('%I:%M %p')
        talk('Current time is ' + time)
    elif 'who is' in command:
        person = command.replace('who is', '')
        info = wikipedia.summary(person, 1)
        print(info)
        talk(info)
    elif 'date' in command:
        if 'go' in command:
            talk('sorry, I have a headache')
        else:
            time = datetime.datetime.now()
            talk('Today is ' )
            engine.say(f'{time.day}')
            engine.say(f'{time.month}')
            talk(f'{time.year}')
        #talk('sorry, I have a headache')

    elif 'are you single' in command:
        talk('I am in a relationship with wifi')
    elif 'joke' in command:
        talk(pyjokes.get_joke())
    elif 'come here' in command:
        engine.setProperty('voice', HINDI_IN_LEKHA)
        talk("तेरी चुम्मी खाने  तोह  लोग  दूर  दूर  से  आते  है , मै   क्या  पास  रहके  भी  न  खावा ,    खाऊंगा !")
    elif 'exit' in command or 'end' in command:
        exit(0)
    else:
        talk('Please say the command again.')


while True:
   run_alexa()
