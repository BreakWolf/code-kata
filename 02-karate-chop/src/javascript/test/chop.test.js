// test/chop.test.js
const  chop  = require('../src/chop.js');


describe('Karate Chop', () => {


  test('empty array', () => {
    expect(chop(3, [])).toBe(-1);
  });

  test('single element', () => {
    expect(chop(1, [1])).toBe(0);
    expect(chop(3, [1])).toBe(-1);
  });

  test('multiple elements', () => {
    expect(chop(1, [1, 3, 5])).toBe(0);
    expect(chop(3, [1, 3, 5])).toBe(1);
    expect(chop(5, [1, 3, 5])).toBe(2);
    expect(chop(0, [1, 3, 5])).toBe(-1);
    expect(chop(2, [1, 3, 5])).toBe(-1);
    expect(chop(6, [1, 3, 5])).toBe(-1);
  });
});
