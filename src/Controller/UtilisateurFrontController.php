<?php

namespace App\Controller;

use App\Entity\Utilisateur;
use App\Form\UtilisateurType;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class UtilisateurFrontController extends AbstractController
{



    /**
     * @Route("/utilisateurFront/{idUtilisateur}", name="utilisateur_front")
     */
    public function index(Utilisateur $utilisateur): Response
    {
        return $this->render('utilisateur_front/index.html.twig', [
            'utilisateur' => $utilisateur,
        ]);
    }


     /**
     * @Route("/", name="utilisateur_front_index")
     */
    public function displayAll(): Response
    {
        $utilisateurs = $this->getDoctrine()
        ->getRepository(Utilisateur::class)
        ->findAll();

    return $this->render('utilisateur_front/display.html.twig', [
        'utilisateurs' => $utilisateurs,
    ]);
    }

/**
     * @Route("/utilisateurFrontnew", name="utilisateur_front_new", methods={"GET","POST"})
     */
    public function new(Request $request): Response
    {
        $idd=110;
        $utilisateur = new Utilisateur();
        $form = $this->createForm(UtilisateurType::class, $utilisateur);
        $form->handleRequest($request);
        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->persist($utilisateur);
            $entityManager->flush();
            $id =$utilisateur->getIdUtilisateur();

            return $this->redirectToRoute('utilisateur_front',['idUtilisateur'=>$id]);
        }

        return $this->render('utilisateur_front/new.html.twig', [
            'utilisateur' => $utilisateur,
            'form' => $form->createView(),
        ]);
    }


     /**
     * @Route("/utilisateurFront/{idUtilisateur}/edit", name="utilisateur_front_edit", methods={"GET","POST"})
     */
    public function edit(Request $request, Utilisateur $utilisateur): Response
    {
        $form = $this->createForm(UtilisateurType::class, $utilisateur);
        $form->handleRequest($request);
        $id =$utilisateur->getIdUtilisateur();
        if ($form->isSubmitted() && $form->isValid()) {
            $this->getDoctrine()->getManager()->flush();

            return $this->redirectToRoute('utilisateur_front',['idUtilisateur'=>$id]);
        }

        return $this->render('utilisateur_front/edit.html.twig', [
            'utilisateur' => $utilisateur,
            'form' => $form->createView(),
        ]);
    }


}
