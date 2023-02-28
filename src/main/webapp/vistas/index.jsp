<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Silicon Solutions</title>
   <link rel="stylesheet" href="webapp/css/bootstrap.min.css" />
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css?family=Inter:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&amp;display=swap"
    />
</head>
 <body>
 <jsp:include page="nav.jsp"></jsp:include>
    <header class="bg-primary-gradient">
      <div class="container pt-4 pt-xl-5">
        <div class="row pt-5">
          <div class="col-md-8 col-xl-6 text-center text-md-start mx-auto">
            <div class="text-center">
              <p class="fw-bold text-success mb-2">#1 En todo el mundo</p>
              <h1 class="fw-bold">La mejor solución para nuestros clientes</h1>
            </div>
          </div>
          <div class="col-12 col-lg-10 mx-auto">
            <div
              class="position-relative"
              style="display: flex; flex-wrap: wrap; justify-content: flex-end"
            >
              <div class = "mb-5"
                style="
                  position: relative;
                  flex: 35%;
                  transform: translate3d(-15%, 35%, 0);
                "
              >
                <img
                  class="img-fluid rounded-5"
                  data-bss-parallax=""
                  data-bss-parallax-speed="0.8"
                  src="https://topesdegama.com/app/uploads-topesdegama.com/2022/09/graficas-portada.jpg?x=480&y=375&quality=40"
                />
              </div>
              <div
                style="
                  position: relative;
                  flex: 35%;
                  transform: translate3d(-5%, 20%, 0);
                "
              >
                <img
                  class="img-fluid rounded-5"
                  data-bss-parallax="0.5"
                  data-bss-parallax-speed="0.4"
                  src="https://cdn.computerhoy.com/sites/navi.axelspringer.es/public/media/image/2022/03/monitor-vertical-2654285.jpg"
                />
              </div>
            </div>
          </div>
        </div>
      </div>
    </header>
    <section class="py-5">
      <div class="container text-center py-5 mt-5">
        <p class="mb-4" style="font-size: 1.6rem">
          Confían en nosotros más de 2,000 empresas tecnológicas
        </p>
        <a href="#">
          <img class="m-3  "style="height: 40px" src="https://tse3.mm.bing.net/th?id=OIP.G3YB4DWoPBPCCLTskF7m2QHaHa&pid=Api&P=0" /></a
        ><a href="#">
          <img class="m-3 "style="height: 40px" src="data:image/jpeg;base64,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" /></a
        ><a href="#"> <img class="m-3"style="height: 40px" src="data:image/png;base64,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" /></a
        ><a href="#"> <img class="m-3" style="height: 40px"src="https://i.pinimg.com/originals/46/c5/ff/46c5ff2bd12e7bbc1532f966bd5914b0.jpg" /></a
        ><a href="#">
          <img class="m-3" style="height: 40px" src="https://1000marcas.net/wp-content/uploads/2020/10/Shopify-Logo.jpg" /></a
        ><a href="#">
          <img class="m-3" style="height: 40px"src="data:image/png;base64,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"
        /></a>
      </div>
    </section>
    <section>
      <div class="container bg-primary-gradient py-5">
        <div class="row">
          <div class="col-md-8 col-xl-6 text-center mx-auto">
            <p class="fw-bold text-success mb-2">Nuestros servicios</p>
            <h3 class="fw-bold">Qué podemos hacer por ti.</h3>
          </div>
        </div>
        <div class="py-5 p-lg-5">
          <div
            class="row row-cols-1 row-cols-md-2 mx-auto"
            style="max-width: 900px"
          >
            <div class="col mb-5">
              <div class="card shadow-sm">
                <div class="card-body px-4 py-5 px-md-5">
                  <div
                    class="bs-icon-lg d-flex justify-content-center align-items-center mb-3 bs-icon"
                    style="top: 1rem; right: 1rem; position: absolute"
                  >
                    <svg
                      xmlns="http://www.w3.org/2000/svg"
                      width="1em"
                      height="1em"
                      fill="currentColor"
                      viewBox="0 0 16 16"
                      class="bi bi-bell"
                    >
                      <path
                        d="M8 16a2 2 0 0 0 2-2H6a2 2 0 0 0 2 2zM8 1.918l-.797.161A4.002 4.002 0 0 0 4 6c0 .628-.134 2.197-.459 3.742-.16.767-.376 1.566-.663 2.258h10.244c-.287-.692-.502-1.49-.663-2.258C12.134 8.197 12 6.628 12 6a4.002 4.002 0 0 0-3.203-3.92L8 1.917zM14.22 12c.223.447.481.801.78 1H1c.299-.199.557-.553.78-1C2.68 10.2 3 6.88 3 6c0-2.42 1.72-4.44 4.005-4.901a1 1 0 1 1 1.99 0A5.002 5.002 0 0 1 13 6c0 .88.32 4.2 1.22 6z"
                      ></path>
                    </svg>
                  </div>
                  <h5 class="fw-bold card-title">Visita nuestro catálogo</h5>
                  <p class="text-muted card-text mb-4">
                    Tenemos a vuestra disposición una amplia gama de productos.
                    No dudes en visitarla y haz tu primer pedido.
                  </p>
                  <a href="/producto/todos" class="btn btn-primary btn-sm mt-3">
                    Ver cátalogo
                  </a>
                </div>
              </div>
            </div>
            <div class="col mb-5">
              <div class="card shadow-sm">
                <div class="card-body px-4 py-5 px-md-5">
                  <div
                    class="bs-icon-lg d-flex justify-content-center align-items-center mb-3 bs-icon"
                    style="top: 1rem; right: 1rem; position: absolute"
                  >
                    <svg
                      xmlns="http://www.w3.org/2000/svg"
                      width="1em"
                      height="1em"
                      fill="currentColor"
                      viewBox="0 0 16 16"
                      class="bi bi-bezier"
                    >
                      <path
                        fill-rule="evenodd"
                        d="M0 10.5A1.5 1.5 0 0 1 1.5 9h1A1.5 1.5 0 0 1 4 10.5v1A1.5 1.5 0 0 1 2.5 13h-1A1.5 1.5 0 0 1 0 11.5v-1zm1.5-.5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1zm10.5.5A1.5 1.5 0 0 1 13.5 9h1a1.5 1.5 0 0 1 1.5 1.5v1a1.5 1.5 0 0 1-1.5 1.5h-1a1.5 1.5 0 0 1-1.5-1.5v-1zm1.5-.5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1zM6 4.5A1.5 1.5 0 0 1 7.5 3h1A1.5 1.5 0 0 1 10 4.5v1A1.5 1.5 0 0 1 8.5 7h-1A1.5 1.5 0 0 1 6 5.5v-1zM7.5 4a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1z"
                      ></path>
                      <path
                        d="M6 4.5H1.866a1 1 0 1 0 0 1h2.668A6.517 6.517 0 0 0 1.814 9H2.5c.123 0 .244.015.358.043a5.517 5.517 0 0 1 3.185-3.185A1.503 1.503 0 0 1 6 5.5v-1zm3.957 1.358A1.5 1.5 0 0 0 10 5.5v-1h4.134a1 1 0 1 1 0 1h-2.668a6.517 6.517 0 0 1 2.72 3.5H13.5c-.123 0-.243.015-.358.043a5.517 5.517 0 0 0-3.185-3.185z"
                      ></path>
                    </svg>
                  </div>
                  <h5 class="fw-bold card-title">Registrate</h5>
                  <p class="text-muted card-text mb-4">
                    Podrás ver nuestro amplio abanico de productos, pero solo
                    podrás hacer un pedido si te has registrado. Hazlo ya !
                  </p>
                  <a href="/registro" class="btn btn-primary btn-sm mt-3">
                    Registro
                  </a>
                </div>
              </div>
            </div>
            <div class="col mb-4">
              <div class="card shadow-sm">
                <div class="card-body px-4 py-5 px-md-5">
                  <div
                    class="bs-icon-lg d-flex justify-content-center align-items-center mb-3 bs-icon"
                    style="top: 1rem; right: 1rem; position: absolute"
                  >
                    <svg
                      xmlns="http://www.w3.org/2000/svg"
                      width="1em"
                      height="1em"
                      fill="currentColor"
                      viewBox="0 0 16 16"
                      class="bi bi-pin-angle"
                    >
                      <path
                        d="M9.828.722a.5.5 0 0 1 .354.146l4.95 4.95a.5.5 0 0 1 0 .707c-.48.48-1.072.588-1.503.588-.177 0-.335-.018-.46-.039l-3.134 3.134a5.927 5.927 0 0 1 .16 1.013c.046.702-.032 1.687-.72 2.375a.5.5 0 0 1-.707 0l-2.829-2.828-3.182 3.182c-.195.195-1.219.902-1.414.707-.195-.195.512-1.22.707-1.414l3.182-3.182-2.828-2.829a.5.5 0 0 1 0-.707c.688-.688 1.673-.767 2.375-.72a5.922 5.922 0 0 1 1.013.16l3.134-3.133a2.772 2.772 0 0 1-.04-.461c0-.43.108-1.022.589-1.503a.5.5 0 0 1 .353-.146zm.122 2.112v-.002.002zm0-.002v.002a.5.5 0 0 1-.122.51L6.293 6.878a.5.5 0 0 1-.511.12H5.78l-.014-.004a4.507 4.507 0 0 0-.288-.076 4.922 4.922 0 0 0-.765-.116c-.422-.028-.836.008-1.175.15l5.51 5.509c.141-.34.177-.753.149-1.175a4.924 4.924 0 0 0-.192-1.054l-.004-.013v-.001a.5.5 0 0 1 .12-.512l3.536-3.535a.5.5 0 0 1 .532-.115l.096.022c.087.017.208.034.344.034.114 0 .23-.011.343-.04L9.927 2.028c-.029.113-.04.23-.04.343a1.779 1.779 0 0 0 .062.46z"
                      ></path>
                    </svg>
                  </div>
                  <h5 class="fw-bold card-title">Estoy buscando..</h5>
                  <p class="text-muted card-text mb-4">
                    Si crees que hay algún producto que es un imprescindible y
                    no lo tenemos, háznoslo saber y lo añadiremos
                    inmediatamente.
                  </p>
                  <a href="mailto:solutions@edix.com" class="btn btn-primary btn-sm mt-3">
                    Mandar email
                  </a>
                </div>
              </div>
            </div>
            <div class="col mb-4">
              <div class="card shadow-sm">
                <div class="card-body px-4 py-5 px-md-5">
                  <div
                    class="bs-icon-lg d-flex justify-content-center align-items-center mb-3 bs-icon"
                    style="top: 1rem; right: 1rem; position: absolute"
                  >
                    <svg
                      xmlns="http://www.w3.org/2000/svg"
                      width="1em"
                      height="1em"
                      fill="currentColor"
                      viewBox="0 0 16 16"
                      class="bi bi-chat-quote"
                    >
                      <path
                        d="M2.678 11.894a1 1 0 0 1 .287.801 10.97 10.97 0 0 1-.398 2c1.395-.323 2.247-.697 2.634-.893a1 1 0 0 1 .71-.074A8.06 8.06 0 0 0 8 14c3.996 0 7-2.807 7-6 0-3.192-3.004-6-7-6S1 4.808 1 8c0 1.468.617 2.83 1.678 3.894zm-.493 3.905a21.682 21.682 0 0 1-.713.129c-.2.032-.352-.176-.273-.362a9.68 9.68 0 0 0 .244-.637l.003-.01c.248-.72.45-1.548.524-2.319C.743 11.37 0 9.76 0 8c0-3.866 3.582-7 8-7s8 3.134 8 7-3.582 7-8 7a9.06 9.06 0 0 1-2.347-.306c-.52.263-1.639.742-3.468 1.105z"
                      ></path>
                      <path
                        d="M7.066 6.76A1.665 1.665 0 0 0 4 7.668a1.667 1.667 0 0 0 2.561 1.406c-.131.389-.375.804-.777 1.22a.417.417 0 0 0 .6.58c1.486-1.54 1.293-3.214.682-4.112zm4 0A1.665 1.665 0 0 0 8 7.668a1.667 1.667 0 0 0 2.561 1.406c-.131.389-.375.804-.777 1.22a.417.417 0 0 0 .6.58c1.486-1.54 1.293-3.214.682-4.112z"
                      ></path>
                    </svg>
                  </div>
                  <h5 class="fw-bold card-title">¿Necesitas ayuda?</h5>
                  <p class="text-muted card-text mb-4">
                    Nuestro equipo técnico te echará un "cable" cuando estés
                    atascado. No dudes en ponerte en contacto con nosotros.
                  </p>
                  <a href="mailto:help@silicon.com" class="btn btn-primary btn-sm mt-3">
                    Ayuda
                  </a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <section></section>
    <section class="py-5 mt-5">
      <div class="container py-5">
        <div class="row mb-5">
          <div class="col-md-8 col-xl-6 text-center mx-auto">
            <p class="fw-bold text-success mb-2">Testimonios</p>
            <h2 class="fw-bold">Qué dice la gente sobre nosotros</h2>
            <p class="text-muted">
              "No importa que componente estás buscando, ellos lo tienen"&nbsp;
            </p>
          </div>
        </div>
        <div
          class="row row-cols-1 row-cols-sm-2 row-cols-lg-3 d-sm-flex justify-content-sm-center"
        >
          <div class="col mb-4">
            <div
              class="d-flex flex-column align-items-center align-items-sm-start"
            >
              <p class="bg-light border rounded border-light p-4">
               	Estaba buscando las últimas
                tarjetas gráficas del mercado y me quedé asombrado de la
                cantidad de stock que tienen.
              </p>
              <div class="d-flex">
                <img
                  class="rounded-circle flex-shrink-0 me-3 fit-cover"
                  width="50"
                  height="50"
                  src="data:image/jpeg;base64,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"
                />
                <div>
                  <p class="fw-bold text-primary mb-0">Adrián González</p>
                  <p class="text-muted mb-0">Cliente</p>
                </div>
              </div>
            </div>
          </div>
          <div class="col mb-4">
            <div
              class="d-flex flex-column align-items-center align-items-sm-start"
            >
              <p class="bg-light border rounded border-light p-4">
                Buscaba un microprocesador calidad-precio, y me dieron soporte
                en todo momento. Estoy encantado con la elección.
              </p>
              <div class="d-flex">
                <img
                  class="rounded-circle flex-shrink-0 me-3 fit-cover"
                  width="50"
                  height="50"
                  src="https://media.istockphoto.com/id/1347495868/es/foto/hombre-afroamericano-sonriente-con-gafas.jpg?b=1&s=170667a&w=0&k=20&c=TFS5Otf_ek_tOvhSv_TYBQ_F4yeXgU0ytHw-6BQ-fKw="
                />
                <div>
                  <p class="fw-bold text-primary mb-0">Raúl Manrique</p>
                  <p class="text-muted mb-0">Cliente</p>
                </div>
              </div>
            </div>
          </div>
          <div class="col mb-4">
            <div
              class="d-flex flex-column align-items-center align-items-sm-start"
            >
              <p class="bg-light border rounded border-light p-4">
                No es solo la cantidad de productos que ofrecen, también entra
                en juego el apasionante equipo técnico que lo hace posible.
              </p>
              <div class="d-flex">
                <img
                  class="rounded-circle flex-shrink-0 me-3 fit-cover"
                  width="50"
                  height="50"
                  src="https://img.freepik.com/foto-gratis/retrato-mujer-caucasica-sonriendo_53876-24998.jpg?w=2000"
                />
                <div>
                  <p class="fw-bold text-primary mb-0">Marta Díaz</p>
                  <p class="text-muted mb-0">Cliente</p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <section class="py-5">
      <div class="container">
        <div class="row mb-5">
          <div class="col-md-8 col-xl-6 text-center mx-auto">
            <p class="fw-bold text-success mb-2">Contacto</p>
            <h2 class="fw-bold">Dónde puedes encontrarnos</h2>
          </div>
        </div>
        <div class="row d-flex justify-content-center">
          <div class="col-md-6 col-xl-4">
            <div>
              <form class="p-3 p-xl-4" method="post">
                <div class="mb-3">
                  <input
                    class="form-control"
                    type="text"
                    id="name-1"
                    name="name"
                    placeholder="Name"
                  />
                </div>
                <div class="mb-3">
                  <input
                    class="form-control"
                    type="email"
                    id="email-1"
                    name="email"
                    placeholder="Email"
                  />
                </div>
                <div class="mb-3">
                  <textarea
                    class="form-control"
                    id="message-1"
                    name="message"
                    rows="6"
                    placeholder="Message"
                  ></textarea>
                </div>
                <div>
                  <button
                    class="btn btn-primary shadow d-block w-100"
                    type="submit"
                  >
                    Enviar
                  </button>
                </div>
              </form>
            </div>
          </div>
          <div
            class="col-md-4 col-xl-4 d-flex justify-content-center justify-content-xl-start"
          >
            <div
              class="d-flex flex-wrap flex-md-column justify-content-md-start align-items-md-start h-100"
            >
              <div class="d-flex align-items-center p-3">
                <div
                  class="bs-icon-md bs-icon-circle bs-icon-primary shadow d-flex flex-shrink-0 justify-content-center align-items-center d-inline-block bs-icon bs-icon-md"
                >
                  <svg
                    xmlns="http://www.w3.org/2000/svg"
                    width="1em"
                    height="1em"
                    fill="currentColor"
                    viewBox="0 0 16 16"
                    class="bi bi-telephone"
                  >
                    <path
                      d="M3.654 1.328a.678.678 0 0 0-1.015-.063L1.605 2.3c-.483.484-.661 1.169-.45 1.77a17.568 17.568 0 0 0 4.168 6.608 17.569 17.569 0 0 0 6.608 4.168c.601.211 1.286.033 1.77-.45l1.034-1.034a.678.678 0 0 0-.063-1.015l-2.307-1.794a.678.678 0 0 0-.58-.122l-2.19.547a1.745 1.745 0 0 1-1.657-.459L5.482 8.062a1.745 1.745 0 0 1-.46-1.657l.548-2.19a.678.678 0 0 0-.122-.58L3.654 1.328zM1.884.511a1.745 1.745 0 0 1 2.612.163L6.29 2.98c.329.423.445.974.315 1.494l-.547 2.19a.678.678 0 0 0 .178.643l2.457 2.457a.678.678 0 0 0 .644.178l2.189-.547a1.745 1.745 0 0 1 1.494.315l2.306 1.794c.829.645.905 1.87.163 2.611l-1.034 1.034c-.74.74-1.846 1.065-2.877.702a18.634 18.634 0 0 1-7.01-4.42 18.634 18.634 0 0 1-4.42-7.009c-.362-1.03-.037-2.137.703-2.877L1.885.511z"
                    ></path>
                  </svg>
                </div>
                <div class="px-2">
                  <h6 class="fw-bold mb-0">Teléfono</h6>
                  <p class="text-muted mb-0">+123456789</p>
                </div>
              </div>
              <div class="d-flex align-items-center p-3">
                <div
                  class="bs-icon-md bs-icon-circle bs-icon-primary shadow d-flex flex-shrink-0 justify-content-center align-items-center d-inline-block bs-icon bs-icon-md"
                >
                  <svg
                    xmlns="http://www.w3.org/2000/svg"
                    width="1em"
                    height="1em"
                    fill="currentColor"
                    viewBox="0 0 16 16"
                    class="bi bi-envelope"
                  >
                    <path
                      fill-rule="evenodd"
                      d="M0 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V4Zm2-1a1 1 0 0 0-1 1v.217l7 4.2 7-4.2V4a1 1 0 0 0-1-1H2Zm13 2.383-4.708 2.825L15 11.105V5.383Zm-.034 6.876-5.64-3.471L8 9.583l-1.326-.795-5.64 3.47A1 1 0 0 0 2 13h12a1 1 0 0 0 .966-.741ZM1 11.105l4.708-2.897L1 5.383v5.722Z"
                    ></path>
                  </svg>
                </div>
                <div class="px-2">
                  <h6 class="fw-bold mb-0">Email</h6>
                  <p class="text-muted mb-0">info@edix.com</p>
                </div>
              </div>
              <div class="d-flex align-items-center p-3">
                <div
                  class="bs-icon-md bs-icon-circle bs-icon-primary shadow d-flex flex-shrink-0 justify-content-center align-items-center d-inline-block bs-icon bs-icon-md"
                >
                  <svg
                    xmlns="http://www.w3.org/2000/svg"
                    width="1em"
                    height="1em"
                    fill="currentColor"
                    viewBox="0 0 16 16"
                    class="bi bi-pin"
                  >
                    <path
                      d="M4.146.146A.5.5 0 0 1 4.5 0h7a.5.5 0 0 1 .5.5c0 .68-.342 1.174-.646 1.479-.126.125-.25.224-.354.298v4.431l.078.048c.203.127.476.314.751.555C12.36 7.775 13 8.527 13 9.5a.5.5 0 0 1-.5.5h-4v4.5c0 .276-.224 1.5-.5 1.5s-.5-1.224-.5-1.5V10h-4a.5.5 0 0 1-.5-.5c0-.973.64-1.725 1.17-2.189A5.921 5.921 0 0 1 5 6.708V2.277a2.77 2.77 0 0 1-.354-.298C4.342 1.674 4 1.179 4 .5a.5.5 0 0 1 .146-.354zm1.58 1.408-.002-.001.002.001zm-.002-.001.002.001A.5.5 0 0 1 6 2v5a.5.5 0 0 1-.276.447h-.002l-.012.007-.054.03a4.922 4.922 0 0 0-.827.58c-.318.278-.585.596-.725.936h7.792c-.14-.34-.407-.658-.725-.936a4.915 4.915 0 0 0-.881-.61l-.012-.006h-.002A.5.5 0 0 1 10 7V2a.5.5 0 0 1 .295-.458 1.775 1.775 0 0 0 .351-.271c.08-.08.155-.17.214-.271H5.14c.06.1.133.191.214.271a1.78 1.78 0 0 0 .37.282z"
                    ></path>
                  </svg>
                </div>
                <div class="px-2">
                  <h6 class="fw-bold mb-0">Localización</h6>
                  <p class="text-muted mb-0">12 Vía Lusitana</p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <footer class="bg-primary-gradient">
      <div class="container py-4 py-lg-5">
        <div class="row justify-content-center">
          <div
            class="col-sm-4 col-md-3 text-center text-lg-start d-flex flex-column"
          >
            <h3 class="fs-6 fw-bold">Servicios</h3>
            <ul class="list-unstyled">
              <li><a href="#">Diseño web</a></li>
              <li><a href="#">Desarrollo</a></li>
              <li><a href="#">Hosting</a></li>
            </ul>
          </div>
          <div
            class="col-sm-4 col-md-3 text-center text-lg-start d-flex flex-column"
          >
            <h3 class="fs-6 fw-bold">Sobre</h3>
            <ul class="list-unstyled">
              <li><a href="#">Compañia</a></li>
              <li><a href="#">Equipo</a></li>
              <li><a href="#">Legal</a></li>
            </ul>
          </div>
          <div
            class="col-sm-4 col-md-3 text-center text-lg-start d-flex flex-column"
          >
            <h3 class="fs-6 fw-bold">Carrera</h3>
            <ul class="list-unstyled">
              <li><a href="#">Ofertas de empleo</a></li>
              <li><a href="#">Empleados</a></li>
              <li><a href="#">Beneficios</a></li>
            </ul>
          </div>
          <div
            class="col-lg-3 text-center text-lg-start d-flex flex-column align-items-center order-first align-items-lg-start order-lg-last"
          >
            <div class="fw-bold d-flex align-items-center mb-2">
              <span
                class="bs-icon-sm bs-icon-circle bs-icon-primary d-flex justify-content-center align-items-center bs-icon me-2"
                ><svg
                  xmlns="http://www.w3.org/2000/svg"
                  width="1em"
                  height="1em"
                  fill="currentColor"
                  viewBox="0 0 16 16"
                  class="bi bi-bezier"
                >
                  <path
                    fill-rule="evenodd"
                    d="M0 10.5A1.5 1.5 0 0 1 1.5 9h1A1.5 1.5 0 0 1 4 10.5v1A1.5 1.5 0 0 1 2.5 13h-1A1.5 1.5 0 0 1 0 11.5v-1zm1.5-.5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1zm10.5.5A1.5 1.5 0 0 1 13.5 9h1a1.5 1.5 0 0 1 1.5 1.5v1a1.5 1.5 0 0 1-1.5 1.5h-1a1.5 1.5 0 0 1-1.5-1.5v-1zm1.5-.5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1zM6 4.5A1.5 1.5 0 0 1 7.5 3h1A1.5 1.5 0 0 1 10 4.5v1A1.5 1.5 0 0 1 8.5 7h-1A1.5 1.5 0 0 1 6 5.5v-1zM7.5 4a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1z"
                  ></path>
                  <path
                    d="M6 4.5H1.866a1 1 0 1 0 0 1h2.668A6.517 6.517 0 0 0 1.814 9H2.5c.123 0 .244.015.358.043a5.517 5.517 0 0 1 3.185-3.185A1.503 1.503 0 0 1 6 5.5v-1zm3.957 1.358A1.5 1.5 0 0 0 10 5.5v-1h4.134a1 1 0 1 1 0 1h-2.668a6.517 6.517 0 0 1 2.72 3.5H13.5c-.123 0-.243.015-.358.043a5.517 5.517 0 0 0-3.185-3.185z"
                  ></path></svg></span
              ><span>Marca</span>
            </div>
            <p class="text-muted">
              Construyendo un equipo tecnológico desde 2022.
            </p>
          </div>
        </div>
        <hr />
        <div
          class="text-muted d-flex justify-content-between align-items-center pt-3"
        >
          <p class="mb-0">Copyright © 2023 Brand</p>
          <ul class="list-inline mb-0">
            <li class="list-inline-item">
              <svg
                xmlns="http://www.w3.org/2000/svg"
                width="1em"
                height="1em"
                fill="currentColor"
                viewBox="0 0 16 16"
                class="bi bi-facebook"
              >
                <path
                  d="M16 8.049c0-4.446-3.582-8.05-8-8.05C3.58 0-.002 3.603-.002 8.05c0 4.017 2.926 7.347 6.75 7.951v-5.625h-2.03V8.05H6.75V6.275c0-2.017 1.195-3.131 3.022-3.131.876 0 1.791.157 1.791.157v1.98h-1.009c-.993 0-1.303.621-1.303 1.258v1.51h2.218l-.354 2.326H9.25V16c3.824-.604 6.75-3.934 6.75-7.951z"
                ></path>
              </svg>
            </li>
            <li class="list-inline-item">
              <svg
                xmlns="http://www.w3.org/2000/svg"
                width="1em"
                height="1em"
                fill="currentColor"
                viewBox="0 0 16 16"
                class="bi bi-twitter"
              >
                <path
                  d="M5.026 15c6.038 0 9.341-5.003 9.341-9.334 0-.14 0-.282-.006-.422A6.685 6.685 0 0 0 16 3.542a6.658 6.658 0 0 1-1.889.518 3.301 3.301 0 0 0 1.447-1.817 6.533 6.533 0 0 1-2.087.793A3.286 3.286 0 0 0 7.875 6.03a9.325 9.325 0 0 1-6.767-3.429 3.289 3.289 0 0 0 1.018 4.382A3.323 3.323 0 0 1 .64 6.575v.045a3.288 3.288 0 0 0 2.632 3.218 3.203 3.203 0 0 1-.865.115 3.23 3.23 0 0 1-.614-.057 3.283 3.283 0 0 0 3.067 2.277A6.588 6.588 0 0 1 .78 13.58a6.32 6.32 0 0 1-.78-.045A9.344 9.344 0 0 0 5.026 15z"
                ></path>
              </svg>
            </li>
            <li class="list-inline-item">
              <svg
                xmlns="http://www.w3.org/2000/svg"
                width="1em"
                height="1em"
                fill="currentColor"
                viewBox="0 0 16 16"
                class="bi bi-instagram"
              >
                <path
                  d="M8 0C5.829 0 5.556.01 4.703.048 3.85.088 3.269.222 2.76.42a3.917 3.917 0 0 0-1.417.923A3.927 3.927 0 0 0 .42 2.76C.222 3.268.087 3.85.048 4.7.01 5.555 0 5.827 0 8.001c0 2.172.01 2.444.048 3.297.04.852.174 1.433.372 1.942.205.526.478.972.923 1.417.444.445.89.719 1.416.923.51.198 1.09.333 1.942.372C5.555 15.99 5.827 16 8 16s2.444-.01 3.298-.048c.851-.04 1.434-.174 1.943-.372a3.916 3.916 0 0 0 1.416-.923c.445-.445.718-.891.923-1.417.197-.509.332-1.09.372-1.942C15.99 10.445 16 10.173 16 8s-.01-2.445-.048-3.299c-.04-.851-.175-1.433-.372-1.941a3.926 3.926 0 0 0-.923-1.417A3.911 3.911 0 0 0 13.24.42c-.51-.198-1.092-.333-1.943-.372C10.443.01 10.172 0 7.998 0h.003zm-.717 1.442h.718c2.136 0 2.389.007 3.232.046.78.035 1.204.166 1.486.275.373.145.64.319.92.599.28.28.453.546.598.92.11.281.24.705.275 1.485.039.843.047 1.096.047 3.231s-.008 2.389-.047 3.232c-.035.78-.166 1.203-.275 1.485a2.47 2.47 0 0 1-.599.919c-.28.28-.546.453-.92.598-.28.11-.704.24-1.485.276-.843.038-1.096.047-3.232.047s-2.39-.009-3.233-.047c-.78-.036-1.203-.166-1.485-.276a2.478 2.478 0 0 1-.92-.598 2.48 2.48 0 0 1-.6-.92c-.109-.281-.24-.705-.275-1.485-.038-.843-.046-1.096-.046-3.233 0-2.136.008-2.388.046-3.231.036-.78.166-1.204.276-1.486.145-.373.319-.64.599-.92.28-.28.546-.453.92-.598.282-.11.705-.24 1.485-.276.738-.034 1.024-.044 2.515-.045v.002zm4.988 1.328a.96.96 0 1 0 0 1.92.96.96 0 0 0 0-1.92zm-4.27 1.122a4.109 4.109 0 1 0 0 8.217 4.109 4.109 0 0 0 0-8.217zm0 1.441a2.667 2.667 0 1 1 0 5.334 2.667 2.667 0 0 1 0-5.334z"
                ></path>
              </svg>
            </li>
          </ul>
        </div>
      </div>
    </footer>
    <script src="webapp/javascript/bootstrap.min.js"></script>
    <script src="webapp/javascript/script.min.js"></script>
  </body>
</html>