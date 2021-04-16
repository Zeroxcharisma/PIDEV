<?php

namespace App\Controller;

use App\Entity\Panier;
use App\Form\PanierType;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class PanierFrontController extends AbstractController
{
    /**
     * @Route("/panierFront", name="panier_front")
     */
    public function index(): Response
    {

        $paniers = $this->getDoctrine()
        ->getRepository(Panier::class)
        ->findAll();

       return $this->render('panier_front/index.html.twig', [
            'paniers' => $paniers,
        ]);
    }



     /**
     * @Route("/panierFront/{id}", name="panier_front_delete", methods={"POST"})
     */
    public function delete(Request $request, Panier $panier): Response
    {
        if ($this->isCsrfTokenValid('delete'.$panier->getId(), $request->request->get('_token'))) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->remove($panier);
            $entityManager->flush();
        }

        return $this->redirectToRoute('panier_front');
    }



/**
     * @Route("/panierFrontProducts", name="panier_front_products", methods={"GET","POST"})
     */
    public function showproducts()
    {
       
        return $this->render('panier_front/products.html.twig'
        );
    }



     /**
     * @Route("/panierFrontNew/{nom}/{prix}/{qte}/{total}", name="panier_front_new", methods={"GET","POST"})
     */
    public function new(Request $request, String $nom, int $prix, int $qte, int $total): Response
    {
        $panier = new Panier();
        $panier->setNom();
        $panier->setPrix();
        $panier->setQte();
        $panier->setTotal();

       

      
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->persist($panier);
            $entityManager->flush();

            return $this->redirectToRoute('panier_front');
        

     
    }

}
