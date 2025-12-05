console.log("fafasdfsa")

fetch("./commentList")
	.then(r => r.text())
	.then(r => console.log(r))
	.catch(e => console.log(e))

;