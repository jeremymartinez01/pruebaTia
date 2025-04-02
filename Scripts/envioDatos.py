import requests
import os

ruta_descargas = os.path.join(os.path.expanduser("~"), "Downloads")
ruta_archivo = os.path.join(ruta_descargas, "Enemigos.txt")

BASE_URL = "http://localhost:8080"

with open(ruta_archivo, encoding='utf-8') as file:
    next(file)

    for linea in file:
        datos = linea.strip().split('|')

        potencia, hostilidad, ubicacion, frente, numero_tropas, tipo_tropas, hora_despliegue = datos

        enemigo_data = {
            "potencia": potencia,
            "hostilidad": int(hostilidad),
            "ubicacion": ubicacion
        }
        respuesta_enemigos = requests.post(f"{BASE_URL}/enemigos", json=enemigo_data)

        if respuesta_enemigos.status_code in [200, 201]:
            print(f"[OK] Enviado enemigo: {enemigo_data}")
        else:
            print(f"[ERROR] Enemigo: {respuesta_enemigos.status_code}")

        tropas_data = {
            "potencia": potencia,
            "frente": frente,
            "numeroTropas": int(numero_tropas),
            "tipoTropas": tipo_tropas,
            "horaDespliegue": hora_despliegue
        }
        respuesta_tropas = requests.post(f"{BASE_URL}/tropas", json=tropas_data)

        if respuesta_tropas.status_code in [200, 201]:
            print(f"[OK] Enviado tropas: {tropas_data}")
        else:
            print(f"[ERROR] Tropas: {respuesta_tropas.status_code}")
