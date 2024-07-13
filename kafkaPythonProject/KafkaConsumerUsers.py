import json

from kafka import KafkaConsumer

consumer = KafkaConsumer('users',
              bootstrap_servers='192.168.1.23:9092',
              key_deserializer=lambda k: json.loads(k.decode('utf-8')),
              value_deserializer=lambda v: json.loads(v.decode('utf-8')),
              auto_offset_reset='latest')

topic_keys = dict()

for msg in consumer:
    if msg.partition not in topic_keys:
        topic_keys[msg.partition] = []
    if msg.key not in topic_keys[msg.partition]:
        topic_keys[msg.partition].append(msg.key)

print(topic_keys)
