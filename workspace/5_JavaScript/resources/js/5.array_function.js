let members = [
    "최지원",
    "김지원",
    "이지원",
    "박지원",
    "남궁지원"
]

// push
console.log(members.push("신지원"));    // 값을 넣고 길이 반환
console.log(members)

// splice(인덱스, 갯수) -> 원본에 영향을 줌
// console.log(members.splice(1, 3));      // 1번 인덱스부터 3번 인덱스 (3번째)까지 출력하고 자름
// console.log(members);

// slice(인덱스, 마지막 인덱스 - 1) -> 원본에 영향을 주지 않음
console.log(members.slice(1, 5));
console.log(members);

console.log("---------------------------------------------------------")

members = [
    "최지원",
    "김지원",
    "이지원",
    "박지원",
    "남궁지원"
]

let member2 = [
    ...members      // members 요소가 들어옴
]

let choi = {
    name : "jiwon",
    age : 21,
    gender : "남",
}

let choi2 = {
    ...choi,
    age : 20    // 요소를 가져온 후, age을 20으로 바꿈
}

console.log(choi);
console.log(choi2);

console.log("-----------------------------------------------------------");

// join() -> 배열을 문자열로 변경해줌
console.log(member2.join());
console.log(member2.join('/'));
console.log(member2.join(' '));

// sort()
member2.sort();
console.log(member2);
console.log(member2.reverse());     // 역순

let numbers = [1, 9, 7, 5, 3]
console.log(numbers);
numbers.sort();
console.log(numbers);
console.log(numbers.reverse());

// a, b를 비교한다
// 1) a를 b보다 나중에 정렬하고 싶다면(뒤에 두고 싶다면) 0 보다 큰 수를 반환
// 2) a를 b보다 나중에 정렬하고 싶다면(앞에 두려면) 0보다 작은 숫자를 반환
// 3) 원래 순서 유지하고 싶다면 0을 반환
// numbers.sort(() => { // 나만의 정렬방식을 사용하고 싶다면 => {}를 사용 아래는 예시
//     return a > b ? 1 : -1;  // 오름차순 정렬
//     return a < b ? 1 : -1;  // 내람차순 정렬
// });
console.log(numbers);

console.log("--------------------------------------------------------");

// map
// 기존 배열의 요소를 전부 반복하면서
// return된 값으로 새로운 배열을 만들어주는 함수
// 기존의 배열을 이용해 새로운 배열을 만들어준다.
// let tmpMember = member2.map(function(m, i) {
//     console.log(m)
//     console.log(i)
//     return {
//         index : i,
//         value : m
//     };
// })
let userList = [
    {
        userKey : 1,
        userName : "최지원",
        age : 22,
    },
    {
        userKey : 2,
        userName : "김수민",
        age : 47,
    },
    {
        userKey : 3,
        userName : "박지수",
        age : 35,
    }
]

let buyHistory = [
    {
        userKey : 2,
        productName : "TV",
        price : 50000
    },
    {
        userKey : 2,
        productName : "모니터",
        price : 20000
    },
    {
        userKey : 1,
        productName : "컴퓨터",
        price : 150000
    },
    {
        userKey : 3,
        productName : "냉장고",
        price : 10000
    },
    {
        userKey : 1,
        productName : "가습기",
        price : 7500
    }
]

buyHistory = buyHistory.map(history => {
    for(let user of userList) {
        if (user.userKey === history.userKey) {
            return {
                ...user,
                ...history
            }
        }
    }
})

buyHistory = buyHistory.map((h, i) => {
    return {
        ...h,
        index : i + 1
    }
})


// console.log(buyHistory);
// let names = [...member2]
// let ages = [21, 32, 15, 20, 50] 

// console.log(tmpMember)

console.log("--------------------------------------------------------");

// filter
// return 값이 false 요소를 제외하고 true인 요소만 가져올 때
let numbers2 = [1, 6, 7, 9, 10, 21];
let tmp2 = [];
// for(let n of numbers2) {
//     if(n % 2 === 0) {
//         tmp2.push(n);
//     }
// }

// console.log(tmp2);

tmp2 = numbers2.filter(n => n % 2 ===0);

console.log(tmp2)

// 내가 삭제하고자하는게 userKey === 2인 것
buyHistory = buyHistory.filter(h => h.userKey !== 2);
console.log(buyHistory);

// find()
// return되는 조건에 값이 true인 첫 요소를 반환
// 모든 요소가 조건에 부합하지 않는다면 (false를 리턴한다면) undefined를 반환
console.log(tmp2.find(n => n % 2 ===0));

// findIndex();
// return되는 조건에 값이 true인 첫 요소의 인덱스를 반환
// 모든 요소가 조건에 부합하지 않는다면(false를 리턴한다면) -1을 반환
console.log(tmp2.findIndex(n => n % 2 ===0));