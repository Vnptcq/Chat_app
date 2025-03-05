const toggle = () => {
    const container = document.getElementById('container');
    container.classList.toggle('sign-in');
    container.classList.toggle('sign-up');
};

export { toggle };