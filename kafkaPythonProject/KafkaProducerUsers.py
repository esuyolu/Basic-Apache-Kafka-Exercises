import json
import requests
import time
from kafka import KafkaProducer

response = requests.get(url='https://random-data-api.com/api/v2/users?size=100')

datas = response.json()

producer = KafkaProducer(bootstrap_servers='192.168.1.23:9092',
                         client_id='python-producer',
                         key_serializer=lambda k: json.dumps(k).encode('utf-8'),
                         value_serializer=lambda v: json.dumps(v).encode('utf-8'))

# for data in datas:
#     producer.send('users', key=str(data['id'] % 32), value=data)
#     time.sleep(1.3)

while True:
    response = requests.get(url='https://random-data-api.com/api/v2/users?size=100')
    datas = response.json()
    for data in datas:
        producer.send('users', key=str(data['id'] % 32), value=data)
        time.sleep(1)
