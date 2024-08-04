import sys

file = open(sys.argv[1], "r")
lines = file.readlines()
file.close()

sum = 0

print("{:<10}{:<20}{:<10}{:<10}".format("Price", "Seller", "Date", "Sum"))
for line in lines:
    line = line.split()
    if len(line) != 3:
        continue
    price = float(line[0])
    seller = line[1]
    date = line[2]
    sum += price
    print("{:<10}{:<20}{:<10}{:<10}".format(price, seller, date, sum))

print("\nTotal:", sum)
