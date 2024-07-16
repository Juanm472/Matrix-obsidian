import org.eclipse.paho.client.mqttv3.*;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    private static final String BROKER = "tcp://192.168.10.11:1883"; // Cambiar por la IP del broker Mosquitto
    private static final String CLIENT_ID = "mqtt_java_client";
    private static final String TOPIC = "sensor/water";
    private static final String LOG_FILE = "log_mqtt_messages.txt";

    private static final String BUZZER_MESSAGE = "WATER_DETECTED";

    public static void main(String[] args) {
        try {
            MqttClient client = new MqttClient(BROKER, CLIENT_ID);
            MqttConnectOptions options = new MqttConnectOptions();
            client.connect(options);

            client.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable cause) {
                    System.out.println("Conexión perdida: " + cause.getMessage());
                }

                @Override
                public void messageArrived(String topic, MqttMessage message) {
                    String payload = new String(message.getPayload());
                    System.out.println("Mensaje recibido en el tema '" + topic + "': " + payload);

                    guardarMensajeEnArchivo(payload);

                    if (payload.equals(BUZZER_MESSAGE)) {
                        activarBuzzer();
                    }
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {
                }
            });

            client.subscribe(TOPIC);

        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    private static void guardarMensajeEnArchivo(String message) {
        try {
            FileWriter writer = new FileWriter(LOG_FILE, true);
            LocalDateTime now = LocalDateTime.now();
            String formattedDateTime = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            writer.write(formattedDateTime + " - " + message + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void activarBuzzer() {
        // Lógica para activar el buzzer
        System.out.println("Buzzer activado");
    }
}
