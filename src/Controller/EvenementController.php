<?php

namespace App\Controller;

use App\Entity\Evenement;
use App\Entity\Evenementlike;
use App\Form\EvenementType;
use App\Repository\EvenementRepository;
use App\Repository\EvenementlikeRepository;
use Doctrine\Persistence\ObjectManager;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;


/**
 * @Route("/evenement")
 */
class EvenementController extends AbstractController
{
    /**
     * @Route("/", name="evenement_index", methods={"GET"})
     */
    public function index(EvenementRepository $evenementRepository): Response
    {
        return $this->render('admin/evenement/index.html.twig', [
            'evenements' => $evenementRepository->findAll(),
        ]);
    }
    /**
     * @Route("/Front", name="evenement_indexFront", methods={"GET"})
     */
    public function indexFront(EvenementRepository $evenementRepository): Response
    {
        return $this->render('evenement/index.html.twig', [
            'evenements' => $evenementRepository->findAll(),
        ]);
    }

    /**
     * @Route("/EvTrier", name="evenement_Trier", methods={"GET"})
     */
    public function evTrier(EvenementRepository $evenementRepository): Response
    {
        return $this->render('evenement/index.html.twig', [
            'evenements' => $evenementRepository->eventTrier(),
        ]);
    }




    /**
     * @Route("/new", name="evenement_new", methods={"GET","POST"})
     */
    public function new(Request $request): Response
    {
        $evenement = new Evenement();
        $form = $this->createForm(EvenementType::class, $evenement);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {

            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->persist($evenement);
            $entityManager->flush();

            return $this->redirectToRoute('evenement_index');
        }

        return $this->render('admin/evenement/new.html.twig', [
            'evenement' => $evenement,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{id}", name="evenement_show", methods={"GET"})
     */
    public function show(Evenement $evenement): Response
    {
        return $this->render('admin/evenement/show.html.twig', [
            'evenement' => $evenement,
        ]);
    }


    /**
     * @Route("/{id}/Front", name="evenement_showFront", methods={"GET"})
     */
    public function showFront(Evenement $evenement): Response
    {
        return $this->render('evenement/show.html.twig', [
            'evenement' => $evenement,
        ]);
    }

    /**
     * @Route("/{id}/edit", name="evenement_edit", methods={"GET","POST"})
     */
    public function edit(Request $request, Evenement $evenement): Response
    {
        $form = $this->createForm(EvenementType::class, $evenement);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $this->getDoctrine()->getManager()->flush();

            return $this->redirectToRoute('evenement_index');
        }

        return $this->render('admin/evenement/edit.html.twig', [
            'evenement' => $evenement,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{id}", name="evenement_delete", methods={"POST"})
     */
    public function delete(Request $request, Evenement $evenement): Response
    {
        if ($this->isCsrfTokenValid('delete'.$evenement->getId(), $request->request->get('_token'))) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->remove($evenement);
            $entityManager->flush();
        }

        return $this->redirectToRoute('evenement_index');
    }


    /**
     * @param Evenement $Evenement
     * @param ObjectManager $manager
     * @param EvenementlikeRepository $evenementlikeRepository
     * @return Response
     * permet de liker ou unliker des evenements
     * @Route("/{id}/like",name="Evenement_like")
     */
    public function like(Evenement $evenement, EvenementlikeRepository $evenementlikeRepository): Response{


        //http status code error handler

        $em=$this->getDoctrine()->getManager();


        //$user = $this->getUser();
        //user not connected
        //if(!$user) return $this->json([
          //  'code ' => 403,
        //    'message'=> "unauthorized"
      //  ], 403);



        //créer un nouveau like
        $like = new Evenementlike();
        $like->setEvenement($evenement);
        //    ->setUser($user);
        $em->persist($like);
        $em->flush();

        return $this->json([
            'code ' => 200 ,
            'message'=>'like bien ajouter',
            'likes'=> $evenementlikeRepository->count(['evenement'=>$evenement])
        ],200);
    }
    /**
     * @param Evenement $Evenement
     * @param ObjectManager $manager
     * @param EvenementlikeRepository $evenementlikeRepository
     * @return Response
     * permet de unliker des evenements
     * @Route("/{id}/dislike",name="Evenement_dislike")
     */
    public function dislike(Evenement $evenement, EvenementlikeRepository $evenementlikeRepository): Response
    {
        //http status code error handler

        $em=$this->getDoctrine()->getManager();
        //Evenement deja aimé
        //supprimer un like pour un user
        //  if($evenement->isLikedByUser($user)){
        $like = $evenementlikeRepository->findOneBy([
            'evenement'=>$evenement,
        ]);
        $evenement->removeEvenementlike($like);
        $em->flush();

        return $this->json([
            'code'=>200,
            'message'=>'like bien supprimer',
            'likes'=> $evenementlikeRepository->count(['evenement'=>$evenement])
        ], 200);

        // }
    }
    }
