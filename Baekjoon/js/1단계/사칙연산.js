const fs = require('fs');

const input = fs
  .readFileSync('/dev/stdin')
  .toString()
  .split(' ')
  .map((el) => +el);

console.log(input[0] + input[1]);
console.log(input[0] - input[1]);
console.log(input[0] * input[1]);
console.log(parseInt(input[0] / input[1], 10));
console.log(input[0] % input[1]);
