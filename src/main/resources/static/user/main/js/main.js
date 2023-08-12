window.onload = function() {
	    
	    /* 프로젝트 블럭 클릭 시 해당 프로젝트 페이지로 이동 */
	    const projectBlock = document.querySelectorAll(".project-block");

			projectBlock.forEach(block => {
			  block.addEventListener("click", (e) => {
			    const projNo = e.currentTarget.dataset.projNo;
			    console.log(projNo);
			    window.location.href = '/project/detail?projNo=' + projNo;
			  });
			});

}