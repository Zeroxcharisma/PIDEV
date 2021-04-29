<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class TestController extends AbstractController
{
    /**
     * @Route("/test", name="test")
     */
    public function index()
    {
        return $this->render('baseFront.html.twig', [
            'controller_name' => 'TestController'
        ]);
    }

    /**
     * @return Response
     * @Route("/t",name="t")
     */
    public function test() {
        return new Response("Good morning");
    }

    /**
     * @Route("affiche/{nom}", name="affiche")
     * @param $nom
     */
    public function affiche($nom) {
        return $this->render("test/affiche.html.twig", [
            'n'=>$nom
        ]);

    }
}
