<b>Java 1.8 + IntelliJ + Maven + Docker + MySQL5.5 + Spring boot + JPA + Bootstrap + Thymeleaf</b>

<b>Instalando o Docker</b><br/>
sudo apt-get install docker<br/>
sudo apt install docker.io<br/>
sudo usermod -aG docker $(whoami)<br/>
faz logout e está pronto<br/>

<b>Criando banco de dados MySQL</b><br/>
docker run -p 3306:3306 --name database-mysql -e MYSQL_ROOT_PASSWORD=teste -d mysql:latest<br/>
docker ps -a<br/>
docker start 'CONTAINER ID'<br/>
docker ps <- Verifica se está rodando o container<br/>
