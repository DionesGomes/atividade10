# parando o container com o nome 'app'
docker stop app
# revemor o container com o nome 'app'
docker rm app
#removendo as images
docker rmi -f atividade10/app

docker stop bd
docker rm bd
docker rmi -f atividade10/bd

#docker-compose
#docker-compose down
