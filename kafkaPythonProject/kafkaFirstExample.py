import json

from kafka import KafkaProducer

# producer = KafkaProducer(bootstrap_servers='192.168.1.23:9092',
#                          client_id='python-producer')
#
# record_meta_data1 = producer.send(topic='test_partition_python', value='hello world'.encode(), key='100'.encode(), partition=5)
#
# print(record_meta_data1.get())

# key ve value json serializer
# producer = KafkaProducer(bootstrap_servers='192.168.1.23:9092',
#                          client_id='python-producer',
#                          key_serializer=lambda k: json.dumps(k).encode('utf-8'),
#                          value_serializer=lambda v: json.dumps(v).encode('utf-8'))
#
# record_meta_data2 = producer.send(topic='test_partition_python', value={'name': 'Abdullah', 'surname': 'Demir', 'age': 30})
#
# print(record_meta_data2.get())

# key ve value string serializer
# producer = KafkaProducer(bootstrap_servers='192.168.1.23:9092',
#                          client_id='python-producer',
#                          key_serializer=str.encode,
#                          value_serializer=str.encode)
#
# record_meta_data3 = producer.send(topic='test_partition_python', value='selam', key='selam')
#
# print(record_meta_data3.get())

# acks config acks=0 serverdan geri dönüş beklemez, acks=1 leader partitiona yazılana kadar bekler, acks='all' replica partitionlara yazılana kadar bekler
producer = KafkaProducer(bootstrap_servers='192.168.1.23:9092',
                         client_id='python-producer',
                         acks='all',
                         retries=3)

record_meta_data4 = producer.send(topic='test_partition_python', value='merhaba kafka topic'.encode(), key='100'.encode())

print(record_meta_data4.get())

producer.flush()

# producer.close()
