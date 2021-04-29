<?php

namespace App\Controller;
use App\Entity\Message;
use App\Form\MessageType;
use App\Repository\MsgRepository;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;

class MsgController extends AbstractController
{
    /**
     * @Route("/msg", name="msg")
     */
    public function index(): Response
    {
        return $this->render('msg/index.html.twig', [
            'controller_name' => 'MsgController',
        ]);
    }
    /**
     * @param Request $request
     * @return RedirectResponse|Response
     * @Route("/msg_up/{id}" , name="msg_up")
     */
    function UpdateM(Request $request) {
        $id=$request->get('id');
        $repo=$this->getDoctrine()->getRepository(Message::class);
      //  $entityManage=$this->getDoctrine()->getManager();
        $oldClass=new Message();
      
        $form=$this->createForm(MessageType::class, $oldClass);
        $form->add("Envoyer", SubmitType::class);
        $form->handleRequest($request);
        
        if ($form->isSubmitted() && $form->isValid()) {
            $em=$this->getDoctrine()->getManager();
            $oldClass->setIdRec($id);
            $em->persist($oldClass);
           $em->flush();
            return $this->redirectToRoute("rec_Affiche");
        }
        $recs = "Repondre à la reclamation ";
        return $this->render("msg/addMsg.html.twig", [
            'f' =>$form->createView(),
            'recs' => $recs
        ]);

    }

     /**
     * @Route("/msg_Affiche", name="msg_Affiche")
     * @param MsgRepository $repo
     * @return Response
     */
    function Afe(MsgRepository $repo) {
        // $repo=$this->getDoctrine()->getRepository(Reclamation::class);
        $msg=$repo->findAll();
        return $this->render("msg/Aff.html.twig", ['msg'=>$msg]);
    }
}
