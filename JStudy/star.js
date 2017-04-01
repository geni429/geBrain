function pyramid_1(){
  for(var i = 0; i < 5; i++){
    var star = "";
    for(var j = 0; j < i+1; j++){
      star += '*';
    }
    console.log(star + '\n');
  }
}

//Array & Object
function ArrayAndObject(){
  var arr = []; //배열 선언
  arr[0] = 0; //배열에 값 대입
  arr[2] = 3; //배열은 가장 큰 인덱스값만큼 배열의 크기를 설정한다. 이 때 값이 초기화되지 않은 인덱스는 undefined로 정의된다.
  console.log(arr.length);  //length는 배열 객체의 _proto_에 있는 메소드로 배열의 인덱스값의 +1된 값을 갖는다.
  arr.property = 'new property'; //배열 객체내에 동적으로 프로퍼티를 생성해줄 수 있다. length에는 영향을 주지 않는다.
  for(var key in arr){
    console.log(key); //배열 또한 객체이기에 key : value 형식으로 저장된다. 따라서 for in 사용시에는 모든 프로퍼티를 받아온다.
  }
  for(var i=0; i<arr.length; i++){
    console.log(arr[i]);  //배열 내에 인덱스 값만을 사용해서 값을 불러오는 것이기 때문에 인덱스 값을 key로 가진 프로퍼티만 출력한다.
  }
  arr.push(4);  //push는 배열 객체의 _proto_안에 있는 표준 메서드로 arr[arr.length]에 ()안에 값을 넣어준다. 가장 끝에 인덱스가 생성되며 값이 대입되는 것이다.
  console.log(arr[3]);  //arr[3] = 4;

  var obj = { //객체 생성
    Obj_property_1 : 'value1',  //key : value 형태로 값을 저장한다. 여러 개인 경우에 ,로 구분한다.
    Obj_property_2 : 'value2'   //Obj_property_1,2 = key, value1,2 = value
  };

}
