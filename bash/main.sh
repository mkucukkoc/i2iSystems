read -p "Input calculation operand (+, -, *, /, %, or !): " operand


if [[ $operand != "!" ]]; then
  read -p "Input number1: " number1
  read -p "Input number2: " number2
else
  read -p "Input number: " number
fi


if [[ $operand == "+" ]]; then
  result=$(($number1 + $number2))
elif [[ $operand == "-" ]]; then
  result=$(($number1 - $number2))
elif [[ $operand == "*" ]]; then
  result=$(($number1 * $number2))
elif [[ $operand == "/" ]]; then
  result=$(($number1 / $number2))
elif [[ $operand == "%" ]]; then
  result=$(($number1 % $number2))
elif [[ $operand == "!" ]]; then
  result=1
  

else
  echo "Invalid operand: $operand"
  exit 1
fi


echo "Result: $result"