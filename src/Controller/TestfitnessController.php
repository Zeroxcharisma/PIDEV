<?php

namespace App\Controller;

use App\Data\FiltreData;
use App\Entity\Testfitness;
use App\Form\FiltreType;
use App\Form\TestfitnessType;
use App\Repository\TestfitnessRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

/**
 * @Route("/testfitness")
 *
 */
class TestfitnessController extends AbstractController
{
    /**
     * @Route("/", name="testfitness_index",methods={"GET"})
     *
     */
    public function index(TestfitnessRepository $testfitnessRepository): Response
    {
        $testfDates = $testfitnessRepository->countByDate();
        $dates = [];
        $testfCount = [];
        foreach($testfDates as $testfDate){
            $dates[] = $testfDate['dateTest'];
            $testfCount[] = $testfDate['count'];
        }

        return $this->render('admin/testfitness/index.html.twig', [
            'testfitnesses' => $testfitnessRepository->findAll(),
            'dates' => json_encode($dates),
            'testfCount' => json_encode($testfCount),

        ]);
    }
    /**
     * @Route("/C", name="testfitness_indexC",methods={"GET","POST"})
     */
    public function indexC(TestfitnessRepository $testfitnessRepository,Request $request): Response
    {
        $dataF = new FiltreData();
        $formF = $this->createForm(FiltreType::class, $dataF);
        $formF->handleRequest($request);
        $testf=$testfitnessRepository->findByFiltre($dataF);
        return $this->render('testfitness/index.html.twig', [
            'testfitnesses' => $testf,
            'formFiltre' => $formF->createView()
        ]);
    }
    /**
     * @Route("/new", name="testfitness_new", methods={"GET","POST"})
     */
    public function new(Request $request): Response
    {
        $testfitness = new Testfitness();
        $form = $this->createForm(TestfitnessType::class, $testfitness);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->persist($testfitness);
            $entityManager->flush();

            return $this->redirectToRoute('testfitness_index');
        }

        return $this->render('admin/testfitness/new.html.twig', [
            'testfitness' => $testfitness,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{id}", name="testfitness_show", methods={"GET"})
     */
    public function show(Testfitness $testfitness): Response
    {
        return $this->render('admin/testfitness/show.html.twig', [
            'testfitness' => $testfitness,
        ]);
    }
    /**
     * @Route("/{id}/C", name="testfitness_showC", methods={"GET"})
     */
    public function showC(Testfitness $testfitness): Response
    {
        return $this->render('testfitness/show.html.twig', [
            'testfitness' => $testfitness,
        ]);
    }

    /**
     * @Route("/{id}/edit", name="testfitness_edit", methods={"GET","POST"})
     */
    public function edit(Request $request, Testfitness $testfitness): Response
    {
        $form = $this->createForm(TestfitnessType::class, $testfitness);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $this->getDoctrine()->getManager()->flush();

            return $this->redirectToRoute('testfitness_index');
        }

        return $this->render('admin/testfitness/edit.html.twig', [
            'testfitness' => $testfitness,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{id}", name="testfitness_delete", methods={"POST"})
     */
    public function delete(Request $request, Testfitness $testfitness): Response
    {
        if ($this->isCsrfTokenValid('delete'.$testfitness->getId(), $request->request->get('_token'))) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->remove($testfitness);
            $entityManager->flush();
        }

        return $this->redirectToRoute('testfitness_index');
    }
}
