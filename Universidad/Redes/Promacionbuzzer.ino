#include <ESP8266WiFi.h>
#include <PubSubClient.h>

// Configuración del WiFi
const char* ssid = "JuanMan"; // Nombre de tu red Wi-Fi
const char* password = "Cilm7400"; // Contraseña de tu red Wi-Fi

// Configuración del broker MQTT
const char* mqtt_server = "192.168.10.11"; // Dirección IP del broker Mosquitto
const char* mqtt_topic = "sensor/water";

// Pin del buzzer
const int buzzerPin = D3; // Cambiar al pin donde está conectado tu buzzer

WiFiClient espClient;
PubSubClient client(espClient);

void setup_wifi() {
  delay(10);
  Serial.println();
  Serial.print("Conectando a ");
  Serial.println(ssid);

  WiFi.begin(ssid, password);

  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }

  Serial.println("");
  Serial.println("WiFi conectado");
  Serial.println("Dirección IP: ");
  Serial.println(WiFi.localIP());
}

void callback(char* topic, byte* payload, unsigned int length) {
  Serial.print("Mensaje recibido en el topico: ");
  Serial.println(topic);
  Serial.print("Payload: ");
  Serial.write(payload, length);
  Serial.println();

  // Verificar si el mensaje recibido es "WATER_DETECTED"
  if (strcmp(topic, mqtt_topic) == 0) {
    if (strncmp((char*)payload, "WATER_DETECTED", length) == 0) {
      // Activar el buzzer
      tone(buzzerPin, 1000); // Cambiar la frecuencia según las especificaciones del buzzer
    } else {
      // Desactivar el buzzer
      noTone(buzzerPin);
    }
  }
}

void reconnect() {
  while (!client.connected()) {
    Serial.print("Conectando al broker MQTT...");
    if (client.connect("ESP8266ClientBuzzer")) {
      Serial.println("conectado");
      client.subscribe(mqtt_topic);
    } else {
      Serial.print("falló, rc=");
      Serial.print(client.state());
      Serial.println(" intentando de nuevo en 5 segundos");
      delay(5000);
    }
  }
}

void setup() {
  Serial.begin(115200);
  pinMode(buzzerPin, OUTPUT);
  setup_wifi();
  client.setServer(mqtt_server, 1883);
  client.setCallback(callback);
}

void loop() {
  if (!client.connected()) {
    reconnect();
  }
  client.loop();
}
