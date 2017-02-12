
### Example Usage

To Clone and run with docker.

```
cd tests/
bash build_docker_image.sh https://github.com/praveenraj1987/busroute.git
bash run_test_docker.sh

```

To run with gradle locally

```
./build.sh
./service.sh start ./tests/docker/example
```

It processes the data at the start of the service and builds up a local lookup of stations for faster access.
Uses embedded jetty and Jersey + Jaxson for Rest Api.