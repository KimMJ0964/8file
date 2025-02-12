/*
    Scope
    변수나 함수가 접근할 수 있는 유효범위
*/

var number1 = 20;

function test1() {
    console.log(number1);
}

// test1();     // 20

function test2() {
    var number1 = 40;
    console.log(number1);
}

// test2();     // 40

var number1 = 20;

function test3() {
    var number1 = 40;
    test4();
    console.log("number1 : " + number1);        // 40
}

function test4() {
    var number2 = 11;
    console.log("number1 : " + number1);        // 20
    console.log("number2 : " + number2);        // 11
}

test3();
console.log(number1);

/*
    JS -> Lexical Scope
    선언된 위치가 상위 스코프를 정한다.

    Dynamic Scope
    실행된 위치가 상위 스코프를 정한다.
 */

var i = 1000;
for(var i = 0; i < 10; i++) {
    console.log(i);         // 0 1 2 3 4 5 6 7 8 9
}

console.log("i = " + i);    // 10


