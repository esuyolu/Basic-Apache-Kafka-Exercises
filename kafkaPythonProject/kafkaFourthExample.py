from kafka import KafkaConsumer

BOOTSTRAP_SERVER = '192.168.1.23:9092'

consumer = KafkaConsumer('test_partition_python', bootstrap_servers=BOOTSTRAP_SERVER, auto_offset_reset='earliest')

for msg in consumer:
    print('Topic: ', msg.topic)
    print('Data: ', msg.value)
    print('Offset:', msg.offset)


