simulate : for (i=1; i<=10; ){
        if(i<3 && Math.floor(Math.random() * 10)+1 >= 0){
            i++
            console.log(`+${i} 나무에 성공 => +${i} 나무`);
        } else if(i<8 && Math.floor(Math.random() * 10)+1 >=5 ){
            i++
            console.log(`+${i} 나무에 성공 => +${i} 나무`);
        } else if(i<8 && Math.floor(Math.random() * 10)+1 < 5){
            i--
            console.log(`+${i} 나무에 실패 => +${i} 나무`);
        } else if(i>=8 && Math.floor(Math.random() * 10)+1 >= 8){
            i++
            console.log(`+${i} 나무에 성공 => +${i} 나무`);
        } else if(i>=8 && Math.floor(Math.random() * 10)+1 < 8){
            i--
            console.log(`+${i} 나무에 실패 => +${i} 나무`);
        } else {}
    if(i===10){
        console.log(`MAX 나무`)
        break simulate;
    }
};