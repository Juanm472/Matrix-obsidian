#include ESP8266WiFi.h
#include PubSubClient.h

 Configuración del WiFi
const char ssid = JuanMan;  Reemplaza con el nombre de tu red Wi-Fi
const char password = Cilm7400;  Reemplaza con la contraseña de tu red Wi-Fi

 Configuración del broker MQTT
const char mqtt_server = 192.168.10.11;  Reemplaza con la dirección IP de tu broker Mosquitto
const char mqtt_topic = sensorwater;

 Pines
const int sensorPin = 4;  Pin GPIO del ESP8266 conectado al sensor de agua

WiFiClient espClient;
PubSubClient client(espClient);

void setup_wifi() {
  delay(10);
   Conectar a la red Wi-Fi
  Serial.println();
  Serial.print(Conectando a );
  Serial.println(ssid);

  WiFi.begin(ssid, password);

  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(.);
  }

  Serial.println();
  Serial.println(WiFi conectado);
  Serial.println(Dirección IP );
  Serial.println(WiFi.localIP());
}

void callback(char topic, byte payload, unsigned int length) {
   Función de devolución de llamada para manejar mensajes entrantes, si es necesario
}

void reconnect() {
   Conectar al broker MQTT
  while (!client.connected()) {
    Serial.print(Conectando al broker MQTT...);
    if (client.connect(ESP8266Client)) {
      Serial.println(conectado);
      client.subscribe(mqtt_topic);  Suscribirse al tema del sensor de agua (opcional)
    } else {
      Serial.print(falló, rc=);
      Serial.print(client.state());
      Serial.println( intentando de nuevo en 5 segundos);
      delay(5000);
    }
  }
}

void setup() {
  Serial.begin(115200);
  pinMode(sensorPin, INPUT);  Configurar el pin del sensor como entrada
  setup_wifi();
  client.setServer(mqtt_server, 1883);
  client.setCallback(callback);
}

void loop() {
  if (!client.connected()) {
    reconnect();
  }
  client.loop();

  int sensorValue = digitalRead(sensorPin);
  if (sensorValue == HIGH) {
    Serial.println(Agua detectada);
    client.publish(mqtt_topic, WATER_DETECTED);
  } else {
    Serial.println(No se detecta agua);
    client.publish(mqtt_topic, NO_WATER);
  }
  delay(5000);  Esperar 5 segundos antes de la siguiente lectura
}