from kafka import KafkaConsumer

BOOTSTRAP_SERVER = '192.168.1.23:9092'

consumer = KafkaConsumer('users',
                         bootstrap_servers=BOOTSTRAP_SERVER,
                         group_id='python-consumer-team2',
                         client_id='python-consumer-instance1',
                         auto_offset_reset='latest',
                         enable_auto_commit=True)

for msg in consumer:
    print(msg)

