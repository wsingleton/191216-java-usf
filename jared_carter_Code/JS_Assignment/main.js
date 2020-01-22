function triangleCheck(numberx,numbery, numberz) {

    if ((numberxnumbery > numberz) && (numberxnumberz > numbery) && (numberynumberz > numberx)) {

        var pre = (numberx + numbery + numberz)/2
        return Math.sqrt(pre*((numberx)*(numbery)*(numberz)));;

	}
	else {
		alert("Undefined.");
	}
  }



    