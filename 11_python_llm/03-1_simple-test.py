inventory = [
    {'name': 'healing_potion', 'type': 'potion', 'grade': 'common', 'price': 50},
    {'name': 'sword_of_legend', 'type': 'weapon', 'grade': 'legendary', 'price': 10000},
    {'name': 'iron_shield', 'type': 'armor', 'grade': 'rare', 'price': 1500},
    {'name': 'mana_potion', 'type': 'potion', 'grade': 'common', 'price': 40}
]
print("초기 인벤토리 데이터:", inventory)

# for문과 if문을 사용해 인벤토리에서 타입(type)이 'potion'인 아이템들의 이름과 가격만 형식에 맞춰 출력하세요.
for type in inventory:
    if type['type'] == 'potion':
        print(f"이름 : {type['name']}, 가격 : {type['price']}")
# 등급(grade)이 'rare' 이상인 아이템들의 이름만 뽑아 새로운 리스트를 만드세요.
# 이때, List Comprehension을 이용해 단 한 줄로 해결해 보세요.
items = [item['name'] for item in inventory if item['grade'] in('rare','legendary') ]
items2 = [item['name'] for item in inventory if item['grade'] == 'rare' or item['grade'] == 'legendary' ]
print(f"rare 이상의 아이템 : {items}")
# 인벤토리의 모든 아이템을 가격(price)이 비싼 순서대로 정렬하여 출력하세요.
# list.sort() 메서드와 lambda 함수를 사용합니다.
items_to_sell = inventory.copy()
items_to_sell.sort(key=lambda p : p['price'], reverse=True)
items_to_sell2 = sorted(inventory, key=lambda p : p['price'], reverse=True)  # sorted함수를 사용해서 한번에 정의 가능
print(f"높은 가격순 : {items_to_sell2}")