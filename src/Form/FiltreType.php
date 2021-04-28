<?php


namespace App\Form;


use App\Data\FiltreData;


use App\Entity\Cours;
use Symfony\Bridge\Doctrine\Form\Type\EntityType;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\Extension\Core\Type\NumberType;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\Form\FormTypeInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;
use Symfony\Component\Form\Extension\Core\Type\DateTimeType;



class FiltreType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder
        ->add('courT', EntityType::class,[
          'label' => false,
          'required'=> false,
            'class' => Cours::class,
            'choice_label' => 'nom',
          'attr' => [
           'placeholder'=>'cour associée'     ]
        ])
        ->add('min', NumberType::class,[
        'label' => false,
        'required'=> false,

        'attr' => [
            'placeholder'=>'durée minimum'     ]
        ])
        ->add('max', NumberType::class,[
            'label' => false,
            'required'=> false,
            'attr' => [
                'placeholder'=>'durée maximum' ]
        ])
            ->add('filtrer',SubmitType::class,[
                'attr' => ['class' => 'btn'],])


        ;
    }
    public function configureOptions(OptionsResolver $resolver)
    {
        $resolver->setDefaults([
            'data_class' => FiltreData::class,
            'method' => 'GET',
            'csrf_protection' => false
        ]);
    }
    public function getBlockPrefix()
    {
        return '';
    }
}