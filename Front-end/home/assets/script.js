/* add hovered class in selected list item */
let list = document.querySelectorAll('.navigation li');
function activeLink() {
    list.forEach((item) => 
    item.classList.remove(''));
    this.classList.add('hovered');
}
list.forEach((item ) => 
item.addEventListener('mouseover', activeLink));

/* Menu toggle */
let toggle = document.querySelector('.toggle');
let navigation = document.querySelector('.navigation');
let topB = document.querySelector('.top');

toggle.onclick = function() {
    navigation.classList.toggle('active');
    topB.classList.toggle('active');
}