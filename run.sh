# Para o banco de dados

docker build -t atividade10/bd ./postgres
docker run -d -p 5431:5432 --name bd atividade10/bd

# Para a aplicação

#mvn spring-boot:build-image

docker build -t atividade10/app .
docker run -d -p 5000:5000 --name app --link  bd:host-banco atividade10/app

