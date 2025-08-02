import random
import string

def generate_password(length):
    if length < 4:
        return "Password length should be at least 4 characters."

    # Define character sets
    letters = string.ascii_letters  # a-z + A-Z
    digits = string.digits          # 0-9
    symbols = string.punctuation    # Special characters

    # Combine all characters
    all_chars = letters + digits + symbols

    # Ensure password has at least one of each type
    password = [
        random.choice(letters),
        random.choice(digits),
        random.choice(symbols)
    ]

    # Fill the rest of the password length
    password += random.choices(all_chars, k=length - 3)

    # Shuffle to avoid predictable patterns
    random.shuffle(password)

    return ''.join(password)

# Main program
try:
    length = int(input("Enter desired password length: "))
    password = generate_password(length)
    print(f"Generated Password: {password}")
except ValueError:
    print("Please enter a valid number.")